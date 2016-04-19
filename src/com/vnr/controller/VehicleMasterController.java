package com.vnr.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vnr.constant.CommonConstants;
import com.vnr.exception.CustomException;
import com.vnr.model.Payment;
import com.vnr.model.StateRef;
import com.vnr.model.VehicleFinance;
import com.vnr.model.VehicleInformation;
import com.vnr.model.VehicleInsurance;
import com.vnr.model.VehicleMaster;
import com.vnr.model.VehicleNationalPermit;
import com.vnr.model.VehicleNationalTax;
import com.vnr.model.VehicleStateTax;
import com.vnr.parameter.PaymentRequest;
import com.vnr.service.ReferenceLookupService;
import com.vnr.service.VehicleMasterService;
import com.vnr.util.DateUtil;
import com.vnr.util.VehicleFormData;
import com.vnr.validator.NationalPermitValidator;
import com.vnr.validator.NationalTaxValidator;
import com.vnr.validator.StateTaxValidator;
import com.vnr.validator.VehicleFinanceValidator;
import com.vnr.validator.VehicleInfoValidator;
import com.vnr.validator.VehicleInsuranceValidator;
import com.vnr.validator.VehicleMasterValidator;

@Controller
public class VehicleMasterController {
	
	private static final Log log = LogFactory.getLog(VehicleMasterController.class);
	
	@Autowired VehicleMasterService vehicleMasterService;
	@Autowired ReferenceLookupService referenceLookupService;
	@Autowired VehicleInfoValidator vehicleInfoValidator;
	@Autowired VehicleFinanceValidator vehicleFinanceValidator;
	@Autowired VehicleMasterValidator vehicleMasterValidator;
	@Autowired NationalTaxValidator nationalTaxValidator;
	@Autowired StateTaxValidator stateTaxValidator;
	@Autowired NationalPermitValidator nationalPermitValidator;
	@Autowired VehicleInsuranceValidator vehicleInsuranceValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@ModelAttribute("searchForm")
    public VehicleInformation searchForm() {
        return new VehicleInformation();
    }
	
	@ModelAttribute("vehicleInformationForm")
    public VehicleInformation vehicleInformationForm() {
        return new VehicleInformation();
    }
	
	@ModelAttribute("vehicleMasterForm")
    public VehicleMaster vehicleMasterForm() {
        return new VehicleMaster();
    }
	
	@RequestMapping(value = "/vehicleTypeList", method = RequestMethod.GET)
    public @ResponseBody List<String> getVehicleTypeList(@RequestParam("term") String name) {		
      
        return VehicleFormData.getVehicleTypeName(name);
    } 
	
	@RequestMapping(value = "/vehicleModelYearList", method = RequestMethod.GET)
    public @ResponseBody List<String> getVehicleModelYearList(@RequestParam("term") String name) {		
      
        return VehicleFormData.getVehicleModelYear(name);
    } 
	
	@RequestMapping(value = "/unitNumberList", method = RequestMethod.GET)
    public @ResponseBody List<String> searchByUnitNumLike(@RequestParam("term") String name) {		
		List<VehicleInformation> vInfos = vehicleMasterService.searchByUnitNumLike(name);
		List<String> uNumbers = new ArrayList<String>();
		for(VehicleInformation vInfo: vInfos) {
			uNumbers.add(vInfo.getUnitNumber());
		}
		log.info("uNumbers"+ uNumbers);
        return uNumbers;
    } 
	
	@RequestMapping(value = "/nextUnitNumber/{term}",  method = RequestMethod.GET)	
    public @ResponseBody String selectLatestUnitNumer(@PathVariable("term") String name) {		
		log.info("name"+ name);
		String latestUnitNum = vehicleMasterService.selectLatestUnitNumber(this.convertName2Code(name));
		String nextNum = this.addNextNumber(latestUnitNum);
		log.info("nextNum"+ nextNum);
        return nextNum;
    } 
	
	
	@RequestMapping(value = "/balanceAmount", method = RequestMethod.POST)	
    public @ResponseBody BigDecimal calculateBalanceAmount(@RequestBody PaymentRequest request) {		
		BigDecimal netPaidAmt = new BigDecimal(0.0);
		BigDecimal balanceAmt = null;
		//this.setUnitNumber(request);
		log.info("getUnitNumber"+ request.getUnitNumber());
		List<Payment> payments = vehicleMasterService.selectPaymentsByObject(request);
		netPaidAmt = this.calculateNetPaidAmount(payments, request);
		log.info("netPaidAmt"+ netPaidAmt);
		
		balanceAmt = request.getTotalAmount().subtract(netPaidAmt);
		
		if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_FINANCE)) {
			VehicleFinance vehicleFinance = vehicleMasterService.selectVehicleFinanceByUnitNum(request.getUnitNumber());			
			if(vehicleFinance != null) {					
				balanceAmt = vehicleFinance.getTotalLoanAmount().subtract(netPaidAmt);
			}
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_NATIONAL_TAX)) {
			VehicleNationalTax vehicleNationalTax = vehicleMasterService.selectVehicleNationalTaxByUnitNum(request.getUnitNumber());			
			if(vehicleNationalTax != null) {				
				balanceAmt = vehicleNationalTax.getNationalTaxAmount().subtract(netPaidAmt);
			}
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_STATE_TAX)) {
			VehicleStateTax vehicleStateTax = vehicleMasterService.selectVehicleStateTaxByUnitNum(request.getUnitNumber());
			if(vehicleStateTax != null) {				
				balanceAmt = vehicleStateTax.getStateTaxAmount().subtract(netPaidAmt);
			}
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_NATIONAL_PERMIT)) {
			VehicleNationalPermit vehicleNationalPermit = vehicleMasterService.selectVehicleNationalPermitByUnitNum(request.getUnitNumber());
			if(vehicleNationalPermit != null) {				
				balanceAmt = vehicleNationalPermit.getNationalPermitAmount().subtract(netPaidAmt);
			}
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_INSURANCE)) {
			VehicleInsurance vehicleInsurance = vehicleMasterService.selectVehicleInsuranceByUnitNum(request.getUnitNumber());
			if(vehicleInsurance != null) {				
				balanceAmt = vehicleInsurance.getInsuranceAmount().subtract(netPaidAmt);
			}
		}
		
		return balanceAmt;		
    } 
	
	@RequestMapping(value = "/stateList", method = RequestMethod.GET)
    public @ResponseBody List<String> searchByStateLike(@RequestParam("term") String name) {		
		List<StateRef> stateRefs = referenceLookupService.searchByStateNameLike(name);
		List<String> states = new ArrayList<String>();
		for(StateRef state: stateRefs) {
			states.add(state.getStateName());
		}
		log.info("states"+ states);
        return states;
    } 
	
	@RequestMapping(value = "/searchVehicle", method = RequestMethod.GET)
    public String displaySearchVehicle(Model model) {		
      
        return "searchVehicle";
    } 

	@RequestMapping(value = "/searchVehicle" , method=RequestMethod.POST)
    public String searchVehicle(@ModelAttribute("searchForm") VehicleInformation vehicleInfo, Model model,
    		BindingResult bindingResult) {        
        
		log.info("Unit Number entered:	"+ vehicleInfo.getUnitNumber());        
        log.info(vehicleInfo.getSubmitAction());
        
        if(vehicleInfo.getSubmitAction().equals(CommonConstants.SEARCH_SUBMIT_ACTION)) {
        	VehicleMaster vehicleMaster =  new VehicleMaster();
        	PaymentRequest request = new PaymentRequest();
        	Payment pymt = null;
        	
        	request.setUnitNumber(vehicleInfo.getUnitNumber());
        	
        	 VehicleInformation vehicleInformation = vehicleMasterService.selectVehicleInformation(vehicleInfo.getUnitNumber());
        	 
        	 VehicleFinance vehicleFinance = vehicleMasterService.selectVehicleFinanceByUnitNum(vehicleInfo.getUnitNumber());
        	 if(vehicleFinance != null) {
        		 request.setPaymentObject(CommonConstants.PAYMENT_OBJECT_FINANCE);
        		 pymt = vehicleMasterService.selectLatestPaymentByObject(request);
            	 vehicleFinance.setCurrentPaidAmount(pymt.getPaidAmount());
            	 vehicleFinance.setCurrentPaidDate(pymt.getPaidDate());
        	 }
        	         	 
        	 VehicleNationalTax vehicleNationalTax = vehicleMasterService.selectVehicleNationalTaxByUnitNum(vehicleInfo.getUnitNumber());
        	 if(vehicleNationalTax != null) {
        		 request.setPaymentObject(CommonConstants.PAYMENT_OBJECT_NATIONAL_TAX);
            	 pymt = vehicleMasterService.selectLatestPaymentByObject(request);
            	 vehicleNationalTax.setCurrentNationalPaidAmount(pymt.getPaidAmount());
            	 vehicleNationalTax.setCurrentNationalPaidDate(pymt.getPaidDate());	 
        	 }
        	         	 
        	 VehicleStateTax vehicleStateTax = vehicleMasterService.selectVehicleStateTaxByUnitNum(vehicleInfo.getUnitNumber());
        	 if(vehicleStateTax != null) {
        		 request.setPaymentObject(CommonConstants.PAYMENT_OBJECT_STATE_TAX);
            	 pymt = vehicleMasterService.selectLatestPaymentByObject(request);
            	 vehicleStateTax.setCurrentStatePaidAmount(pymt.getPaidAmount());
            	 vehicleStateTax.setCurrentStatePaidDate(pymt.getPaidDate());	 
        	 }
        	         	 
        	 VehicleNationalPermit vehicleNationalPermit = vehicleMasterService.selectVehicleNationalPermitByUnitNum(vehicleInfo.getUnitNumber());
        	 if(vehicleNationalPermit != null) {
        		 request.setPaymentObject(CommonConstants.PAYMENT_OBJECT_NATIONAL_PERMIT);
            	 pymt = vehicleMasterService.selectLatestPaymentByObject(request);
            	 vehicleNationalPermit.setCurrentPermitPaidAmount(pymt.getPaidAmount());
            	 vehicleNationalPermit.setCurrentPermitPaidDate(pymt.getPaidDate());	 
        	 }
        	         	 
        	 VehicleInsurance vehicleInsurance = vehicleMasterService.selectVehicleInsuranceByUnitNum(vehicleInfo.getUnitNumber());
        	 if(vehicleInsurance != null) {
        		 request.setPaymentObject(CommonConstants.PAYMENT_OBJECT_INSURANCE);
            	 pymt = vehicleMasterService.selectLatestPaymentByObject(request);
            	 vehicleInsurance.setCurrentInsurancePaidAmount(pymt.getPaidAmount());
            	 vehicleInsurance.setCurrentInsurancePaidDate(pymt.getPaidDate());	 
        	 }
        	         	 
        	 vehicleMaster.setVehicleInformation(vehicleInformation);
        	 vehicleMaster.setVehicleFinance(vehicleFinance);
        	 vehicleMaster.setVehicleNationalTax(vehicleNationalTax);
        	 vehicleMaster.setVehicleStateTax(vehicleStateTax);
        	 vehicleMaster.setVehicleNationalPermit(vehicleNationalPermit);
        	 vehicleMaster.setVehicleInsurance(vehicleInsurance);                     	 
        	 if(vehicleInformation == null ) {
             	 model.addAttribute("message", "No Data Found");           	 
             	 return "searchVehicle";
             }
             //model.addAttribute("message", "Data Found for "+vehicleInfo.getUnitNumber());
             model.addAttribute("vehicleMasterForm", vehicleMaster);
             return "searchVehicleResult";
        } else {        
        	model.addAttribute("vehicleInformationForm", vehicleInfo);
        	this.setVehicleInfoFormData(model);   	        	
        	return "addVehicleInfo";
        }
       
    }
	
	@RequestMapping(value = "/addVehicleInfo", method = RequestMethod.POST)
    public String addVehicleInfo(@ModelAttribute("vehicleInformationForm") VehicleInformation vehicleInfo, Model model,
    		BindingResult bindingResult) {		
		log.info(vehicleInfo.getUnitNumber());
		
		//Direct to add finance form
		if(vehicleInfo.getSubmitAction().equals(CommonConstants.ADD_FINANCE_SUBMIT_ACTION)) {
			this.setVehicleMasterFormData(model);
			
			return "addVehicleMaster";
		}
		
		vehicleInfoValidator.validate(vehicleInfo, bindingResult);
		
		if(bindingResult.hasErrors()) {			
			model.addAttribute("vehicleInformationForm", vehicleInfo);
        	this.setVehicleInfoFormData(model);   
			 return "addVehicleInfo";
		}
		//Save vehicle master data
		//this.prefixVehicleType(vehicleInfo);
		vehicleMasterService.saveVehicleInformation(vehicleInfo); 
		model.addAttribute("message", "Successfully Saved");
		return "addVehicleInfo";
    } 
	
	@RequestMapping(value = "/addVehicleMaster", method = RequestMethod.POST)
	@ExceptionHandler(CustomException.class)
    public String addVehicleMaster(@ModelAttribute("vehicleMasterForm") VehicleMaster vehicleMaster, 
    		Model model, BindingResult bindingResult) {		
		String vehicleType = vehicleMaster.getSelectedVehicleType();		
		VehicleFinance vehicleFinance = vehicleMaster.getVehicleFinance();
		VehicleNationalTax vehicleNationalTax = vehicleMaster.getVehicleNationalTax();
		VehicleStateTax vehicleStateTax = vehicleMaster.getVehicleStateTax();
		VehicleNationalPermit vehicleNationalPermit = vehicleMaster.getVehicleNationalPermit();
		VehicleInsurance vehicleInsurance = vehicleMaster.getVehicleInsurance();						
		
		this.setUnitNumber(vehicleMaster);
		
		//Validate form data
		vehicleMasterValidator.validate(vehicleMaster, bindingResult);		
		vehicleFinanceValidator.validate(vehicleFinance, bindingResult);		
		if(vehicleType.equals(CommonConstants.TRUCK_STRING) || vehicleType.equals(CommonConstants.PRIME_MOVER_TRAILER_STRING)) {
			nationalTaxValidator.validate(vehicleNationalTax, bindingResult);	
			stateTaxValidator.validate(vehicleStateTax, bindingResult);	
			nationalPermitValidator.validate(vehicleNationalPermit, bindingResult);	
			vehicleInsuranceValidator.validate(vehicleInsurance, bindingResult);
		}
		if(bindingResult.hasErrors()) {			
			this.setVehicleMasterFormData(model);
			return "addVehicleMaster";
		}
		//try {
			//Save Vehicle Finance details
			if(vehicleFinance != null){					
				vehicleFinance.setBalanceAmount(
						vehicleFinance.getTotalLoanAmount().subtract(vehicleFinance.getCurrentPaidAmount()));				
				this.saveFinanceDetails(vehicleFinance);
			}
							
			//Save Vehicle National Tax details
			if(vehicleNationalTax != null) {			
				vehicleNationalTax.setNationalTaxBalanceAmount(
						vehicleNationalTax.getNationalTaxAmount().subtract(vehicleNationalTax.getCurrentNationalPaidAmount()));
				vehicleNationalTax.setNationalTaxFlag(this.findWarningColorCode(vehicleNationalTax));		
				this.saveNationalTaxDetails(vehicleNationalTax);
			}				
			
			//Save Vehicle State Tax details
			if(vehicleStateTax != null) {			
				vehicleStateTax.setStateTaxBalanceAmount(
						vehicleStateTax.getStateTaxAmount().subtract(vehicleStateTax.getCurrentStatePaidAmount()));
				vehicleStateTax.setStateTaxFlag(this.findWarningColorCode(vehicleStateTax));
				this.saveStateTaxDetails(vehicleStateTax);
			}
							
			//Save Vehicle National Permit details
			if(vehicleNationalPermit != null) {						
				vehicleNationalPermit.setNationalPermitBalanceAmount(
						vehicleNationalPermit.getNationalPermitAmount().subtract(vehicleNationalPermit.getCurrentPermitPaidAmount()));
				vehicleNationalPermit.setNationalPermitFlag(this.findWarningColorCode(vehicleNationalPermit));
				this.saveNationalPermitDetails(vehicleNationalPermit);
			}
							
			//Save Vehicle Insurance details
			if(vehicleInsurance != null) {			
				vehicleInsurance.setInsuranceBalanceAmount(
						vehicleInsurance.getInsuranceAmount().subtract(vehicleInsurance.getCurrentInsurancePaidAmount()));
				vehicleInsurance.setInsuranceFlag(this.findWarningColorCode(vehicleInsurance));
				this.saveInsuranceDetails(vehicleInsurance);
			}		
		/*} catch(Exception ex) {
			throw new CustomException("Failed to save vehicle master data");
		}*/
		
		model.addAttribute("message", "Successfully Saved");
		this.setVehicleMasterFormData(model);
		return "addVehicleMaster";
    } 
	
	private long findNumberOfDays(Date endDate, Date currentDate) {		
		long days = (endDate.getTime() - currentDate.getTime())/(1000*60*60*24);
		log.info("days:	"+ days);
		return days;
	}
	
	private String findWarningColorCode(Object object) {			
		long numOfDays=0;
		
		if(object instanceof VehicleNationalTax) {
			VehicleNationalTax ref = (VehicleNationalTax)object;			
			numOfDays = this.findNumberOfDays(ref.getNationalTaxEndDate(), DateUtil.getCurrentDate());			
		} else if(object instanceof VehicleStateTax) {
			VehicleStateTax ref = (VehicleStateTax)object;
			numOfDays = this.findNumberOfDays(ref.getStateTaxEndDate(), DateUtil.getCurrentDate());
		} else if(object instanceof VehicleNationalPermit) {
			VehicleNationalPermit ref = (VehicleNationalPermit)object;
			numOfDays = this.findNumberOfDays(ref.getNationalPermitEndDate(), DateUtil.getCurrentDate());
		} else if(object instanceof VehicleInsurance) {
			VehicleInsurance ref = (VehicleInsurance)object;
			numOfDays = this.findNumberOfDays(ref.getInsuranceEndDate(), DateUtil.getCurrentDate());
		}		
		
		if(numOfDays <= 30 && numOfDays > 10)return CommonConstants.WARNING_COLOR_CODE_YELLOW;
		else if(numOfDays <= 10) return CommonConstants.WARNING_COLOR_CODE_RED;
		else return CommonConstants.WARNING_COLOR_CODE_GREEN;
	}
	
	private BigDecimal calculateNetPaidAmount(List<Payment> payments, PaymentRequest request) {
		BigDecimal netPaidAmt = BigDecimal.ZERO;
		for(Payment payment : payments) {			
			netPaidAmt = netPaidAmt.add(payment.getPaidAmount());			
		}		
		netPaidAmt = netPaidAmt.add(request.getPaidAmount());
		return netPaidAmt;
	}
	
	private void setUnitNumber(VehicleMaster vehicleMaster) {
		if(vehicleMaster.getSelectedVehicleType().equals(CommonConstants.TRUCK_STRING)) {
			vehicleMaster.getVehicleFinance().setUnitNumber(vehicleMaster.getTruckUnitNumber());
			vehicleMaster.getVehicleNationalTax().setUnitNumber(vehicleMaster.getTruckUnitNumber());
			vehicleMaster.getVehicleStateTax().setUnitNumber(vehicleMaster.getTruckUnitNumber());
			vehicleMaster.getVehicleNationalPermit().setUnitNumber(vehicleMaster.getTruckUnitNumber());
			vehicleMaster.getVehicleInsurance().setUnitNumber(vehicleMaster.getTruckUnitNumber());
		} else if(vehicleMaster.getSelectedVehicleType().equals(CommonConstants.PRIME_MOVER_STRING)) {
			vehicleMaster.getVehicleFinance().setUnitNumber(vehicleMaster.getPrimeMoverUnitNumber());			
		} else if(vehicleMaster.getSelectedVehicleType().equals(CommonConstants.TRAILER_STRING)) {
			vehicleMaster.getVehicleFinance().setUnitNumber(vehicleMaster.getTrailerUnitNumber());			
		} else {			
			vehicleMaster.getVehicleFinance().setUnitNumber(vehicleMaster.getPrimeMoverUnitNumber());
			vehicleMaster.getVehicleFinance().setChildUnitNumber(vehicleMaster.getTrailerUnitNumber());
			vehicleMaster.getVehicleNationalTax().setUnitNumber(vehicleMaster.getPrimeMoverUnitNumber());
			vehicleMaster.getVehicleNationalTax().setChildUnitNumber(vehicleMaster.getTrailerUnitNumber());
			vehicleMaster.getVehicleStateTax().setUnitNumber(vehicleMaster.getPrimeMoverUnitNumber());
			vehicleMaster.getVehicleStateTax().setChildUnitNumber(vehicleMaster.getTrailerUnitNumber());
			vehicleMaster.getVehicleNationalPermit().setUnitNumber(vehicleMaster.getPrimeMoverUnitNumber());
			vehicleMaster.getVehicleNationalPermit().setChildUnitNumber(vehicleMaster.getTrailerUnitNumber());
			vehicleMaster.getVehicleInsurance().setUnitNumber(vehicleMaster.getPrimeMoverUnitNumber());
			vehicleMaster.getVehicleInsurance().setChildUnitNumber(vehicleMaster.getTrailerUnitNumber());
		}
	}
	
	private void saveFinanceDetails(VehicleFinance vehicleFinance) {		
		if(!StringUtils.isEmpty(vehicleFinance.getStateName())) {
			vehicleFinance.setStateCode(
					referenceLookupService.searchByStateName(vehicleFinance.getStateName()).getStateCode());	
		}
		try {
			vehicleMasterService.saveVehicleFinance(vehicleFinance);			
			vehicleMasterService.savePayment(this.createPaymentObject(vehicleFinance));
		} catch(Exception ex) {			
			log.error("Error Message: "+ex.getMessage());
			throw new CustomException("Failed to Save Finance data");
		}
	}
	
	private void saveNationalTaxDetails(VehicleNationalTax vehicleNationalTax) {
		vehicleMasterService.saveVehicleNationalTax(vehicleNationalTax);				
		vehicleMasterService.savePayment(this.createPaymentObject(vehicleNationalTax));
	}
	
	private void saveStateTaxDetails(VehicleStateTax vehicleStateTax) {
		vehicleMasterService.saveVehicleStateTax(vehicleStateTax);				
		vehicleMasterService.savePayment(this.createPaymentObject(vehicleStateTax));
	}
	
	private void saveNationalPermitDetails(VehicleNationalPermit vehicleNationalPermit) {
		vehicleMasterService.saveVehicleNationalPermit(vehicleNationalPermit);				
		vehicleMasterService.savePayment(this.createPaymentObject(vehicleNationalPermit));
	}
	
	private void saveInsuranceDetails(VehicleInsurance vehicleInsurance) {
		vehicleMasterService.saveVehicleInsurance(vehicleInsurance);				
		vehicleMasterService.savePayment(this.createPaymentObject(vehicleInsurance));
	}
	
	private void setVehicleMasterFormData(Model model) {
		//1. Select all units which are not having any finance data
		List<VehicleInformation> vehicles = vehicleMasterService.selectActiveVehicles();
		model.addAttribute("vehicleTypeList", VehicleFormData.getVehicleTypeList());
		model.addAttribute("truckList", this.splitVehicleType(vehicles, CommonConstants.TRUCK_CODE));
		model.addAttribute("primeMoverList", this.splitVehicleType(vehicles, CommonConstants.PRIME_MOVER_CODE));
		model.addAttribute("trailerList", this.splitVehicleType(vehicles, CommonConstants.TRAILER_CODE));
	}
	
	private void setVehicleInfoFormData(Model model) {		        	
    	model.addAttribute("vehicleTypeList", VehicleFormData.getVehicleTypeList());
    	model.addAttribute("logisticModeList", VehicleFormData.getLogisticModeList());
    	model.addAttribute("vehicleStatusList", VehicleFormData.getVehicleStatusList());
    	model.addAttribute("vehicleMakeList", VehicleFormData.getVehicleMakeList());
    	model.addAttribute("vehicleModelYearList", VehicleFormData.getVehicleModelYearList());
    	model.addAttribute("vehicleHaulingTypeList", VehicleFormData.getVehicleHaulingTypeList());     
	}
	
	private Payment createPaymentObject(Object object) {
		Payment payment = new Payment();	
		
		if(object instanceof VehicleFinance) {
			VehicleFinance vf = (VehicleFinance)object;
			payment.setVehicleFinance(vf);
			payment.setPaidAmount(vf.getCurrentPaidAmount());		
			payment.setPaidDate(vf.getCurrentPaidDate());		
		} else if(object instanceof VehicleNationalTax) {
			VehicleNationalTax vnt = (VehicleNationalTax)object;
			payment.setVehicleNationalTax(vnt);		
			payment.setPaidAmount(vnt.getCurrentNationalPaidAmount());		
			payment.setPaidDate(vnt.getCurrentNationalPaidDate());	
		} else if(object instanceof VehicleStateTax) {
			VehicleStateTax vst = (VehicleStateTax)object;
			payment.setVehicleStateTax(vst);
			payment.setPaidAmount(vst.getCurrentStatePaidAmount());
			payment.setPaidDate(vst.getCurrentStatePaidDate());
		}  else if(object instanceof VehicleNationalPermit) {
			VehicleNationalPermit vnp = (VehicleNationalPermit)object;
			payment.setVehicleNationalPermit(vnp);		
			payment.setPaidAmount(vnp.getCurrentPermitPaidAmount());
			payment.setPaidDate(vnp.getCurrentPermitPaidDate());
		}  else if(object instanceof VehicleInsurance) {
			VehicleInsurance vi = (VehicleInsurance)object;
			payment.setVehicleInsurance(vi);		
			payment.setPaidAmount(vi.getCurrentInsurancePaidAmount());
			payment.setPaidDate(vi.getCurrentInsurancePaidDate());
		}
		
		return payment;
	}
	
	private String addNextNumber(String latestUnitNum) {
		for(int count =0; count < latestUnitNum.length(); count++ ) {
			if(Character.isDigit(latestUnitNum.charAt(count))) {
				String str = latestUnitNum.substring(0, count);
				Long value = Long.parseLong(latestUnitNum.substring(count, latestUnitNum.length()))+1L;
				return str.concat(value.toString());				
			}
		}
		return null;
	}
	private String convertName2Code(String name){
		if(name.equals(CommonConstants.TRUCK_STRING)) return  CommonConstants.TRUCK_CODE;
		else if(name.equals(CommonConstants.PRIME_MOVER_STRING)) return  CommonConstants.PRIME_MOVER_CODE;
		else if(name.equals(CommonConstants.TRAILER_STRING)) return  CommonConstants.TRAILER_CODE;
		return null;
	}
	
	private List<String> splitVehicleType(List<VehicleInformation> vehicles, String typeCode) {
		List<String> unitNumbers = new ArrayList<String>();
		if(typeCode.equals(CommonConstants.TRUCK_CODE)) {
			for(VehicleInformation object : vehicles) {
				if(object.getUnitNumber().startsWith(CommonConstants.TRUCK_CODE) &&
						!object.getUnitNumber().startsWith(CommonConstants.TRAILER_CODE))
					unitNumbers.add(object.getUnitNumber());
			}
		} else if(typeCode.equals(CommonConstants.PRIME_MOVER_CODE)) {
			for(VehicleInformation object : vehicles) {
				if(object.getUnitNumber().startsWith(CommonConstants.PRIME_MOVER_CODE))
					unitNumbers.add(object.getUnitNumber());
			}
		} else if(typeCode.equals(CommonConstants.TRAILER_CODE)) {
			for(VehicleInformation object : vehicles) {
				if(object.getUnitNumber().startsWith(CommonConstants.TRAILER_CODE))
					unitNumbers.add(object.getUnitNumber());
			}
		}
		
		return unitNumbers;
	}
	
	/*private void prefixVehicleType(VehicleInformation vehicleMaster) {
		if(vehicleMaster.getVehicleType().equals(CommonConstants.TRUCK_STRING))
			vehicleMaster.setUnitNumber(CommonConstants.TRUCK_CODE.concat(vehicleMaster.getUnitNumber()));
		else if(vehicleMaster.getVehicleType().equals(CommonConstants.PRIME_MOVER_STRING))
			vehicleMaster.setUnitNumber(CommonConstants.PRIME_MOVER_CODE.concat(vehicleMaster.getUnitNumber()));
		else if(vehicleMaster.getVehicleType().equals(CommonConstants.TRAILER_STRING))
			vehicleMaster.setUnitNumber(CommonConstants.TRAILER_CODE.concat(vehicleMaster.getUnitNumber()));
	}*/
	
	
}
