package com.vnr.model;


public class VehicleMaster {

	
	private VehicleInformation vehicleInformation;
	 
	private VehicleFinance vehicleFinance;
	 
	private VehicleNationalTax vehicleNationalTax;
	 
	private VehicleStateTax vehicleStateTax;
	 
	private VehicleNationalPermit vehicleNationalPermit;
	 
	private VehicleInsurance vehicleInsurance;
	 
	private Payment payment;
		
	String selectedVehicleType;
	String truckUnitNumber;
	String primeMoverUnitNumber;
	String trailerUnitNumber;
	
	public VehicleInformation getVehicleInformation() {
		return vehicleInformation;
	}
	public void setVehicleInformation(VehicleInformation vehicleInformation) {
		this.vehicleInformation = vehicleInformation;
	}
	public VehicleFinance getVehicleFinance() {
		return vehicleFinance;
	}
	public void setVehicleFinance(VehicleFinance vehicleFinance) {
		this.vehicleFinance = vehicleFinance;
	}
	
	public VehicleNationalTax getVehicleNationalTax() {
		return vehicleNationalTax;
	}
	public void setVehicleNationalTax(VehicleNationalTax vehicleNationalTax) {
		this.vehicleNationalTax = vehicleNationalTax;
	}
	public VehicleStateTax getVehicleStateTax() {
		return vehicleStateTax;
	}
	public void setVehicleStateTax(VehicleStateTax vehicleStateTax) {
		this.vehicleStateTax = vehicleStateTax;
	}
	public VehicleNationalPermit getVehicleNationalPermit() {
		return vehicleNationalPermit;
	}
	public void setVehicleNationalPermit(VehicleNationalPermit vehicleNationalPermit) {
		this.vehicleNationalPermit = vehicleNationalPermit;
	}
	public VehicleInsurance getVehicleInsurance() {
		return vehicleInsurance;
	}
	public void setVehicleInsurance(VehicleInsurance vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
	}
	public String getSelectedVehicleType() {
		return selectedVehicleType;
	}
	public void setSelectedVehicleType(String selectedVehicleType) {
		this.selectedVehicleType = selectedVehicleType;
	}
	public String getTruckUnitNumber() {
		return truckUnitNumber;
	}
	public void setTruckUnitNumber(String truckUnitNumber) {
		this.truckUnitNumber = truckUnitNumber;
	}
	public String getPrimeMoverUnitNumber() {
		return primeMoverUnitNumber;
	}
	public void setPrimeMoverUnitNumber(String primeMoverUnitNumber) {
		this.primeMoverUnitNumber = primeMoverUnitNumber;
	}
	public String getTrailerUnitNumber() {
		return trailerUnitNumber;
	}
	public void setTrailerUnitNumber(String trailerUnitNumber) {
		this.trailerUnitNumber = trailerUnitNumber;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
}
