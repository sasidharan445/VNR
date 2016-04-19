package com.vnr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vnr.model.VehicleNationalPermit;

@Component
public class NationalPermitValidator implements Validator {
	
	//private static final Log log = LogFactory.getLog(NationalTaxValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		 return VehicleNationalPermit.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalPermit.nationalPermitAmount", "error.vehicleNationalPermit.nationalPermitAmount", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalPermit.nationalPermitStartDate", "error.vehicleNationalPermit.nationalPermitStartDate", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalPermit.nationalPermitEndDate", "error.vehicleNationalPermit.nationalPermitEndDate", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalPermit.currentPermitPaidAmount", "error.vehicleNationalPermit.currentPermitPaidAmount", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalPermit.currentPermitPaidDate", "error.vehicleNationalPermit.currentPermitPaidDate", "Required");	
	}

}
