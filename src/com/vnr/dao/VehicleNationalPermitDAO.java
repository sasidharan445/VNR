package com.vnr.dao;

import com.vnr.model.VehicleNationalPermit;


public interface VehicleNationalPermitDAO {
	void saveVehicleNationalPermit(VehicleNationalPermit vehicleNationalPermit);
	VehicleNationalPermit selectVehicleNationalPermitByUnitNum(String unitNumber);
	
}
