package com.vnr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vnr.model.VehicleNationalTax;

@Component
public class NationalTaxValidator implements Validator {
	
	//private static final Log log = LogFactory.getLog(NationalTaxValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		 return VehicleNationalTax.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalTax.nationalTaxAmount", "error.vehicleNationalTax.nationalTaxAmount", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalTax.nationalTaxStartDate", "error.vehicleNationalTax.nationalTaxStartDate", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalTax.nationalTaxEndDate", "error.vehicleNationalTax.nationalTaxEndDate", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalTax.currentNationalPaidAmount", "error.vehicleNationalTax.currentNationalPaidAmount", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNationalTax.currentNationalPaidDate", "error.vehicleNationalTax.currentNationalPaidDate", "Required");						 
	}

}
