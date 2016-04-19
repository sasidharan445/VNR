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
@Table(name="VEHICLE_NATIONAL_TAX")
public class VehicleNationalTax implements Serializable {
	
	private static final long serialVersionUID = -7961296356999508715L;
	
	transient private BigDecimal currentNationalPaidAmount;
	transient private Date currentNationalPaidDate;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_NATIONAL_TAX_ID")
	private long vehicleNationalTaxId;
	
	@Column(name="UNIT_NUMBER")
	private String unitNumber;
	
	@Column(name="CHILD_UNIT_NUMBER")
	private String childUnitNumber;
	
	@Column(name="NATIONAL_TAX_AMOUNT")
	private BigDecimal nationalTaxAmount;
	
	@Column(name="NATIONAL_TAX_START_DATE")
	private Date nationalTaxStartDate;
	
	@Column(name="NATIONAL_TAX_END_DATE")
	private Date nationalTaxEndDate;
	
	@Column(name="NATIONAL_TAX_FLAG")
	private String nationalTaxFlag;
	
	@Column(name="NATIONAL_TAX_BALANCE_AMOUNT")
	private BigDecimal nationalTaxBalanceAmount;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;
	
	@OneToMany(mappedBy="vehicleNationalTax",cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Set<Payment> payments;

	public BigDecimal getCurrentNationalPaidAmount() {
		return currentNationalPaidAmount;
	}

	public void setCurrentNationalPaidAmount(BigDecimal currentNationalPaidAmount) {
		this.currentNationalPaidAmount = currentNationalPaidAmount;
	}

	public Date getCurrentNationalPaidDate() {
		return currentNationalPaidDate;
	}

	public void setCurrentNationalPaidDate(Date currentNationalPaidDate) {
		this.currentNationalPaidDate = currentNationalPaidDate;
	}

	public long getVehicleNationalTaxId() {
		return vehicleNationalTaxId;
	}

	public void setVehicleNationalTaxId(long vehicleNationalTaxId) {
		this.vehicleNationalTaxId = vehicleNationalTaxId;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public BigDecimal getNationalTaxAmount() {
		return nationalTaxAmount;
	}

	public void setNationalTaxAmount(BigDecimal nationalTaxAmount) {
		this.nationalTaxAmount = nationalTaxAmount;
	}

	public Date getNationalTaxStartDate() {
		return nationalTaxStartDate;
	}

	public void setNationalTaxStartDate(Date nationalTaxStartDate) {
		this.nationalTaxStartDate = nationalTaxStartDate;
	}

	public Date getNationalTaxEndDate() {
		return nationalTaxEndDate;
	}

	public void setNationalTaxEndDate(Date nationalTaxEndDate) {
		this.nationalTaxEndDate = nationalTaxEndDate;
	}

	public String getNationalTaxFlag() {
		return nationalTaxFlag;
	}

	public void setNationalTaxFlag(String nationalTaxFlag) {
		this.nationalTaxFlag = nationalTaxFlag;
	}

	public BigDecimal getNationalTaxBalanceAmount() {
		return nationalTaxBalanceAmount;
	}

	public void setNationalTaxBalanceAmount(BigDecimal nationalTaxBalanceAmount) {
		this.nationalTaxBalanceAmount = nationalTaxBalanceAmount;
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
