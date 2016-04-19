package com.vnr.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vnr.constant.CommonConstants;

public class VehicleFormData {

	private static Log log = LogFactory.getLog(VehicleFormData.class);

	public static List<String> getVehicleMakeList() {
		
		List<String> makeList = new ArrayList<String>();
		makeList.add(CommonConstants.VEHICLE_MAKE_ASHOK_LEYLAND);
		makeList.add(CommonConstants.VEHICLE_MAKE_DIAMLER);
		makeList.add(CommonConstants.VEHICLE_MAKE_MAHINDRA);
		makeList.add(CommonConstants.VEHICLE_MAKE_MAN);
		makeList.add(CommonConstants.VEHICLE_MAKE_TATA);
		makeList.add(CommonConstants.VEHICLE_MAKE_VOLVO);
		
		return makeList;
	}
	
	public static List<String> getVehicleTypeName(String name) {

	    List<String> returnMatchName = new ArrayList<String>();
	   
	    for (String string : getVehicleTypeList()) {
	        if (string.toUpperCase().indexOf(name.toUpperCase())!= -1) {
	        	returnMatchName.add(string);
	        }
	    }	    
	    return returnMatchName;
	}
	
	public static List<String> getVehicleModelYear(String selectdYear) {

	    List<String> returnMatchName = new ArrayList<String>();
	   
	    for (String year : getVehicleModelYearList()) {
	        if (year.startsWith(selectdYear)) {
	        	returnMatchName.add(year);
	        }
	    }	    
	    log.info("returnMatchName:	"+returnMatchName);
	    return returnMatchName;
	}

	public static List<String> getVehicleModelYearList() {
		
		List<String> modelYear = new ArrayList<String>();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for(int count = currentYear; count >= 1990; count--) {
			modelYear.add(String.valueOf(count));
		}
		return modelYear;
	}
	
	public static List<String> getVehicleTypeList() {
		return Arrays.asList(CommonConstants.TRUCK_STRING, CommonConstants.PRIME_MOVER_STRING,
				CommonConstants.TRAILER_STRING);
	}
	
	public static List<String> getLogisticModeList() {
		return Arrays.asList(CommonConstants.LOGISTIC_MODE_AGENT, CommonConstants.LOGISTIC_MODE_DIRECT);
	}
	
	public static List<String> getVehicleStatusList() {
		return Arrays.asList(CommonConstants.STATUS_ACTIVE, CommonConstants.STATUS_INACTIVE);				
	}
	
	public static List<String> getVehicleHaulingTypeList() {
		return Arrays.asList(CommonConstants.HAULING_TYPE_BIKE, CommonConstants.HAULING_TYPE_CAR,
				CommonConstants.HAULING_TYPE_GENERAL);
	}
	
	
}
