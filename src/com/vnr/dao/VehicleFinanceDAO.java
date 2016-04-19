package com.vnr.dao;

import com.vnr.model.VehicleFinance;


public interface VehicleFinanceDAO {
	void saveVehicleFinance(VehicleFinance vehicleFinance)  throws Exception;
	VehicleFinance selectVehicleFinanceByUnitNum(String unitNumber);
	
}
