package com.vnr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE_NATIONAL_PERMIT")
public class VehicleNationalPermit implements Serializable {

	private static final long serialVersionUID = -2326365424095855988L;
	transient private BigDecimal currentPermitPaidAmount;
	transient private Date currentPermitPaidDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_NATIONAL_PERMIT_ID")
	private long vehicleNationalPermitId;
	
	@Column(name="UNIT_NUMBER")
	private String unitNumber;	
	
	@Column(name="CHILD_UNIT_NUMBER")
	private String childUnitNumber;
	
	@Column(name="NATIONAL_PERMIT_AMOUNT")
	private BigDecimal nationalPermitAmount;
	
	@Column(name="NATIONAL_PERMIT_START_DATE")
	private Date nationalPermitStartDate;
	
	@Column(name="NATIONAL_PERMIT_END_DATE")
	private Date nationalPermitEndDate;
	
	@Column(name="NATIONAL_PERMIT_FLAG")
	private String nationalPermitFlag;
	
	@Column(name="NATIONAL_PERMIT_BALANCE_AMOUNT")
	private BigDecimal nationalPermitBalanceAmount;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;
	
	@OneToMany(mappedBy="vehicleNationalPermit",cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Set<Payment> payments;

	public BigDecimal getCurrentPermitPaidAmount() {
		return currentPermitPaidAmount;
	}

	public void setCurrentPermitPaidAmount(BigDecimal currentPermitPaidAmount) {
		this.currentPermitPaidAmount = currentPermitPaidAmount;
	}

	public Date getCurrentPermitPaidDate() {
		return currentPermitPaidDate;
	}

	public void setCurrentPermitPaidDate(Date currentPermitPaidDate) {
		this.currentPermitPaidDate = currentPermitPaidDate;
	}

	public long getVehicleNationalPermitId() {
		return vehicleNationalPermitId;
	}

	public void setVehicleNationalPermitId(long vehicleNationalPermitId) {
		this.vehicleNationalPermitId = vehicleNationalPermitId;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public BigDecimal getNationalPermitAmount() {
		return nationalPermitAmount;
	}

	public void setNationalPermitAmount(BigDecimal nationalPermitAmount) {
		this.nationalPermitAmount = nationalPermitAmount;
	}

	public Date getNationalPermitStartDate() {
		return nationalPermitStartDate;
	}

	public void setNationalPermitStartDate(Date nationalPermitStartDate) {
		this.nationalPermitStartDate = nationalPermitStartDate;
	}

	public Date getNationalPermitEndDate() {
		return nationalPermitEndDate;
	}

	public void setNationalPermitEndDate(Date nationalPermitEndDate) {
		this.nationalPermitEndDate = nationalPermitEndDate;
	}

	public String getNationalPermitFlag() {
		return nationalPermitFlag;
	}

	public void setNationalPermitFlag(String nationalPermitFlag) {
		this.nationalPermitFlag = nationalPermitFlag;
	}

	public BigDecimal getNationalPermitBalanceAmount() {
		return nationalPermitBalanceAmount;
	}

	public void setNationalPermitBalanceAmount(
			BigDecimal nationalPermitBalanceAmount) {
		this.nationalPermitBalanceAmount = nationalPermitBalanceAmount;
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

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public String getChildUnitNumber() {
		return childUnitNumber;
	}

	public void setChildUnitNumber(String childUnitNumber) {
		this.childUnitNumber = childUnitNumber;
	}

	
}
