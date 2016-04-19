package com.vnr.dao;

import com.vnr.model.VehicleStateTax;


public interface VehicleStateTaxDAO {
	void saveVehicleStateTax(VehicleStateTax vehicleStateTax);
	VehicleStateTax selectVehicleStateTaxByUnitNum(String unitNumber);
	
}
