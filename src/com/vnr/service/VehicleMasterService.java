package com.vnr.service;

import java.util.List;

import com.vnr.model.Payment;
import com.vnr.model.VehicleFinance;
import com.vnr.model.VehicleInformation;
import com.vnr.model.VehicleInsurance;
import com.vnr.model.VehicleNationalPermit;
import com.vnr.model.VehicleNationalTax;
import com.vnr.model.VehicleStateTax;
import com.vnr.parameter.PaymentRequest;

public interface VehicleMasterService {

	VehicleInformation selectVehicleInformation(String unitNumber);
	List<VehicleInformation> selectActiveVehicles();
	void saveVehicleInformation(VehicleInformation vehicleInformation);
	List<VehicleInformation> searchByUnitNumLike(String unitNumber);
	String selectLatestUnitNumber(String vehicleTypeCode);
	
	void saveVehicleFinance(VehicleFinance vehicleFinance)  throws Exception;
	void saveVehicleNationalTax(VehicleNationalTax vehicleNationalTax);
	void saveVehicleStateTax(VehicleStateTax vehicleStateTax);
	void saveVehicleNationalPermit(VehicleNationalPermit vehicleNationalPermit);
	void saveVehicleInsurance(VehicleInsurance vehicleInsurance);

	void savePayment(Payment payment);
	List<Payment> selectPaymentsByObject(PaymentRequest request);
	Payment selectLatestPaymentByObject(PaymentRequest request);
	
	VehicleFinance selectVehicleFinanceByUnitNum(String unitNumber);
	VehicleNationalTax selectVehicleNationalTaxByUnitNum(String unitNumber);
	VehicleStateTax selectVehicleStateTaxByUnitNum(String unitNumber);
	VehicleNationalPermit selectVehicleNationalPermitByUnitNum(String unitNumber);
	VehicleInsurance selectVehicleInsuranceByUnitNum(String unitNumber);
}
