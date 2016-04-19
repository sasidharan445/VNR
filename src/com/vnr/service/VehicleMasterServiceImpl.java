package com.vnr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnr.dao.PaymentDAO;
import com.vnr.dao.VehicleFinanceDAO;
import com.vnr.dao.VehicleInformationDAO;
import com.vnr.dao.VehicleInsuranceDAO;
import com.vnr.dao.VehicleNationalPermitDAO;
import com.vnr.dao.VehicleNationalTaxDAO;
import com.vnr.dao.VehicleStateTaxDAO;
import com.vnr.model.Payment;
import com.vnr.model.VehicleFinance;
import com.vnr.model.VehicleInformation;
import com.vnr.model.VehicleInsurance;
import com.vnr.model.VehicleNationalPermit;
import com.vnr.model.VehicleNationalTax;
import com.vnr.model.VehicleStateTax;
import com.vnr.parameter.PaymentRequest;

@Service
public class VehicleMasterServiceImpl implements VehicleMasterService {
	
	@Autowired VehicleInformationDAO vehicleInformationDAO;
	@Autowired VehicleFinanceDAO vehicleFinanceDAO;
	@Autowired VehicleNationalTaxDAO vehicleNationalTaxDAO;
	@Autowired VehicleStateTaxDAO vehicleStateTaxDAO;
	@Autowired VehicleNationalPermitDAO vehicleNationalPermitDAO;
	@Autowired VehicleInsuranceDAO vehicleInsuranceDAO;
	@Autowired PaymentDAO paymentDAO;
	
	public VehicleInformation selectVehicleInformation(String unitNumber) {
		return vehicleInformationDAO.selectVehicleInformation(unitNumber);
	}
	
	public List<VehicleInformation> selectActiveVehicles() {
		return vehicleInformationDAO.selectActiveVehicles();
	}
	
	public void saveVehicleInformation(VehicleInformation vehicleInformation) {
		vehicleInformationDAO.saveVehicleInformation(vehicleInformation);
	}
	
	public List<VehicleInformation> searchByUnitNumLike(String unitNumber) {
		return vehicleInformationDAO.searchByUnitNumLike(unitNumber);	
	}
	
	public String selectLatestUnitNumber(String vehicleTypeCode) {
		return vehicleInformationDAO.selectLatestUnitNumber(vehicleTypeCode);
	}
	
	
	public void saveVehicleFinance(VehicleFinance vehicleFinance)  throws Exception {
		vehicleFinanceDAO.saveVehicleFinance(vehicleFinance);
	}
	
	public void saveVehicleNationalTax(VehicleNationalTax vehicleNationalTax) {
		vehicleNationalTaxDAO.saveVehicleNationalTax(vehicleNationalTax);
	}
	
	public void saveVehicleStateTax(VehicleStateTax vehicleStateTax) {
		vehicleStateTaxDAO.saveVehicleStateTax(vehicleStateTax);
	}
	
	public void saveVehicleNationalPermit(VehicleNationalPermit vehicleNationalPermit) {
		vehicleNationalPermitDAO.saveVehicleNationalPermit(vehicleNationalPermit);
	}
	
	public void saveVehicleInsurance(VehicleInsurance vehicleInsurance) {
		vehicleInsuranceDAO.saveVehicleInsurance(vehicleInsurance);
	}
	
	
	public void savePayment(Payment payment) {
		paymentDAO.savePayment(payment);
	}
	
	public List<Payment> selectPaymentsByObject(PaymentRequest request) {
		return paymentDAO.selectPaymentsByObject(request);
	}
	
	public Payment selectLatestPaymentByObject(PaymentRequest request) {
		return paymentDAO.selectLatestPaymentByObject(request);
	}
	
	public VehicleFinance selectVehicleFinanceByUnitNum(String unitNumber) {
		return vehicleFinanceDAO.selectVehicleFinanceByUnitNum(unitNumber);
	}
	
	public VehicleNationalTax selectVehicleNationalTaxByUnitNum(String unitNumber) {
		return vehicleNationalTaxDAO.selectVehicleNationalTaxByUnitNum(unitNumber);
	}
	
	public VehicleStateTax selectVehicleStateTaxByUnitNum(String unitNumber) {
		return vehicleStateTaxDAO.selectVehicleStateTaxByUnitNum(unitNumber);
	}
	
	public VehicleNationalPermit selectVehicleNationalPermitByUnitNum(String unitNumber) {
		return vehicleNationalPermitDAO.selectVehicleNationalPermitByUnitNum(unitNumber);
	}
	
	public VehicleInsurance selectVehicleInsuranceByUnitNum(String unitNumber) {
		return vehicleInsuranceDAO.selectVehicleInsuranceByUnitNum(unitNumber);
	}
	
}
