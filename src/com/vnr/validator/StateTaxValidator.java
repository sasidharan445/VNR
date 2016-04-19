package com.vnr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vnr.model.VehicleStateTax;

@Component
public class StateTaxValidator implements Validator {
	
	//private static final Log log = LogFactory.getLog(NationalTaxValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		 return VehicleStateTax.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleStateTax.stateTaxAmount", "error.vehicleStateTax.stateTaxAmount", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleStateTax.stateTaxStartDate", "error.vehicleStateTax.stateTaxStartDate", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleStateTax.stateTaxEndDate", "error.vehicleStateTax.stateTaxEndDate", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleStateTax.currentStatePaidAmount", "error.vehicleStateTax.currentStatePaidAmount", "Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleStateTax.currentStatePaidDate", "error.vehicleStateTax.currentStatePaidDate", "Required");	
								 
	}

}
