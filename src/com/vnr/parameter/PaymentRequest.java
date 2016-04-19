package com.vnr.parameter;

import java.math.BigDecimal;

public class PaymentRequest {

	private String unitNumber;
	private String truckUnitNumber;
	private String primeMoverUnitNumber;
	private String trailerUnitNumber;
	private String paymentObject;
	BigDecimal paidAmount;
	BigDecimal totalAmount;
	
	public String getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	public String getPaymentObject() {
		return paymentObject;
	}
	public void setPaymentObject(String paymentObject) {
		this.paymentObject = paymentObject;
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
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
