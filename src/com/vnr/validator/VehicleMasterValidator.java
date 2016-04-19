package com.vnr.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vnr.constant.CommonConstants;
import com.vnr.model.VehicleMaster;

@Component
public class VehicleMasterValidator implements Validator {
	
	private static final Log log = LogFactory.getLog(VehicleMasterValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		 return VehicleMaster.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {	
		VehicleMaster vehicleMaster = (VehicleMaster)target;
		log.info("selected type:	"+ vehicleMaster.getSelectedVehicleType());
		if(vehicleMaster.getSelectedVehicleType().equals(CommonConstants.TRUCK_STRING)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "truckUnitNumber", "error.truckUnitNumber", "Required");	
		} else if(vehicleMaster.getSelectedVehicleType().equals(CommonConstants.PRIME_MOVER_STRING)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primeMoverUnitNumber", "error.primeMoverUnitNumber", "Required");	
		}  else if(vehicleMaster.getSelectedVehicleType().equals(CommonConstants.TRAILER_STRING)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trailerUnitNumber", "error.trailerUnitNumber", "Required");	
		}  else if(vehicleMaster.getSelectedVehicleType().equals(CommonConstants.PRIME_MOVER_TRAILER_STRING)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primeMoverUnitNumber", "error.primeMoverUnitNumber", "Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trailerUnitNumber", "error.trailerUnitNumber", "Required");	
		} 
	}

}
