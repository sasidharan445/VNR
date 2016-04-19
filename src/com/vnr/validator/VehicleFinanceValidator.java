package com.vnr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vnr.model.VehicleFinance;

@Component
public class VehicleFinanceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		 return VehicleFinance.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {		       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.financeCompanyName", "error.vehicleFinance.financeCompanyName", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.contactName", "error.vehicleFinance.contactName", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.contactNumber", "error.vehicleFinance.contactNumber", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.addressLine1", "error.vehicleFinance.addressLine1", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.city", "error.vehicleFinance.city", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.stateName", "error.vehicleFinance.stateName", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.postalCode", "error.vehicleFinance.postalCode", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.principalAmount", "error.vehicleFinance.principalAmount", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.loanAmount", "error.vehicleFinance.loanAmount", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.rateOfInterest", "error.vehicleFinance.rateOfInterest", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.numberOfMonths", "error.vehicleFinance.numberOfMonths", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.totalLoanAmount", "error.vehicleFinance.totalLoanAmount", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.loanDueDate", "error.vehicleFinance.loanDueDate", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.emiAmount", "error.vehicleFinance.emiAmount", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.emiDueDate", "error.vehicleFinance.emiDueDate", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.currentPaidAmount", "error.vehicleFinance.currentPaidAmount", "Required");       		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleFinance.currentPaidDate", "error.vehicleFinance.emiDueDate", "Required");       				       		
		     
	}

}
