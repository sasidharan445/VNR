package com.vnr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT")
public class Payment implements Serializable {
	
	private static final long serialVersionUID = -4598394088690936546L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAYMENT_ID")
	private long paymentId;
	
	@Column(name="PAID_AMOUNT")
	private BigDecimal paidAmount;
	
	@Column(name="PAID_DATE")
	private Date paidDate;	
	
	/*@Column(name="VEHICLE_FINANCE_ID")
	private long vehicleFinanceId;*/
	
	/*@Column(name="VEHICLE_NATIONAL_TAX_ID")
	private long vehicleNationalTaxId;
	
	@Column(name="VEHICLE_STATE_TAX_ID")
	private long vehicleStateTaxId;
	
	@Column(name="VEHICLE_NATIONAL_PERMIT_ID")
	private long vehicleNationalPermitId;*/
	
	/*@JoinColumn(name="VEHICLE_INSURANCE_ID")
	private long vehicleInsuranceId;*/
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;
	
	@ManyToOne
	@JoinColumn(name="VEHICLE_FINANCE_ID")
	private VehicleFinance vehicleFinance;
	
	@ManyToOne
	@JoinColumn(name="VEHICLE_NATIONAL_TAX_ID")
	private VehicleNationalTax vehicleNationalTax;
	
	@ManyToOne
	@JoinColumn(name="VEHICLE_STATE_TAX_ID")
	private VehicleStateTax vehicleStateTax;
	
	@ManyToOne
	@JoinColumn(name="VEHICLE_NATIONAL_PERMIT_ID")
	private VehicleNationalPermit vehicleNationalPermit;
	
	@ManyToOne
	@JoinColumn(name="VEHICLE_INSURANCE_ID")
	private VehicleInsurance vehicleInsurance;
	
		
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
		
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public VehicleFinance getVehicleFinance() {
		return vehicleFinance;
	}
	public void setVehicleFinance(VehicleFinance vehicleFinance) {
		this.vehicleFinance = vehicleFinance;
	}
	public VehicleInsurance getVehicleInsurance() {
		return vehicleInsurance;
	}
	public void setVehicleInsurance(VehicleInsurance vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
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
	
}
