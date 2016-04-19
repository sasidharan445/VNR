package com.vnr.dao;

import com.vnr.model.VehicleInsurance;


public interface VehicleInsuranceDAO {
	void saveVehicleInsurance(VehicleInsurance vehicleInsurance);
	VehicleInsurance selectVehicleInsuranceByUnitNum(String unitNumber);
	
}
