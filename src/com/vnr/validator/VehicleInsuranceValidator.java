package com.vnr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vnr.model.VehicleInsurance;

@Component
public class VehicleInsuranceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		 return VehicleInsurance.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {		       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleInsurance.insuranceAmount", "error.vehicleInsurance.insuranceAmount", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleInsurance.insuranceStartDate", "error.vehicleInsurance.insuranceStartDate", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleInsurance.insuranceEndDate", "error.vehicleInsurance.insuranceEndDate", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleInsurance.currentInsurancePaidAmount", "error.vehicleInsurance.currentInsurancePaidAmount", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleInsurance.currentInsurancePaidDate", "error.vehicleInsurance.currentInsurancePaidDate", "Required");       		
		     
	}

}
