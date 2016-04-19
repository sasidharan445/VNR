package com.vnr.dao;

import com.vnr.model.VehicleNationalTax;


public interface VehicleNationalTaxDAO {
	void saveVehicleNationalTax(VehicleNationalTax vehicleNationalTax);
	VehicleNationalTax selectVehicleNationalTaxByUnitNum(String unitNumber);
	
}
