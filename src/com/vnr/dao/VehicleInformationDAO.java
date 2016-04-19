package com.vnr.dao;

import java.util.List;

import com.vnr.model.VehicleInformation;

public interface VehicleInformationDAO {
	
	VehicleInformation selectVehicleInformation(String unitNumber);
	List<VehicleInformation> selectActiveVehicles();
	void saveVehicleInformation(VehicleInformation vehicleInfo);
	List<VehicleInformation> searchByUnitNumLike(String unitNumber);
	String selectLatestUnitNumber(String vehicleTypeCode);
}
