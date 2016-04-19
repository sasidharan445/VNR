package com.vnr.validator;


import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vnr.model.VehicleInformation;

@Component
public class VehicleInfoValidator implements Validator {
	
	private static final Log log = LogFactory.getLog(VehicleInfoValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		 return VehicleInformation.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {		       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleType", "error.vehicleType", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "logisticMode", "error.logisticMode", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registrationNumber", "error.registrationNumber", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleStatus", "error.vehicleStatus", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleMake", "error.vehicleMake", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleModel", "error.vehicleModel", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleModelYear", "error.vehicleModelYear", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleEngineNumber", "error.vehicleEngineNumber", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleChassisNumber", "error.vehicleChassisNumber", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleHaulingCapacity", "error.vehicleHaulingCapacity", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleHaulingType", "error.vehicleHaulingType", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleNumOfTyres", "error.vehicleNumOfTyres", "Required");       
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicleLength", "error.vehicleLength", "Required");  
		
		VehicleInformation vehicleInfo = (VehicleInformation)target;
		if(StringUtils.isNotBlank(vehicleInfo.getRegistrationNumber())) {
				this.validateFormat(vehicleInfo.getRegistrationNumber(), errors);
		}
		     
	}
	
	private void validateFormat(String regNumber, Errors errors) {
		String[] strArry = regNumber.split(Pattern.quote(" "));
		log.info(strArry.length);
		
		if(regNumber.length() != 13 || strArry.length != 4 || !isAlpha(strArry[0]) || !isAlpha(strArry[2]) ||
				!isNumeric(strArry[1]) || !isNumeric(strArry[3]) ||
				strArry[0].length() != 2 || strArry[1].length() != 2 || strArry[2].length() != 2 || strArry[3].length() != 4) {
			errors.rejectValue("registrationNumber", "error.registrationNumber", "Invalid Format");
		}				
	}

	public boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}
	
	public static boolean isNumeric(String maybeNumeric) {
	    return maybeNumeric != null && maybeNumeric.matches("[0-9]+");
	}
}
