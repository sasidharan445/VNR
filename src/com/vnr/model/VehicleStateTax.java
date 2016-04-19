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
@Table(name="VEHICLE_STATE_TAX")
public class VehicleStateTax  implements Serializable {
	
	private static final long serialVersionUID = 3005403835754152591L;
	transient private BigDecimal currentStatePaidAmount;
	transient private Date currentStatePaidDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_STATE_TAX_ID")
	private long vehicleStateTaxId;
	
	@Column(name="UNIT_NUMBER")
	private String unitNumber;
	
	@Column(name="CHILD_UNIT_NUMBER")
	private String childUnitNumber;
	
	@Column(name="STATE_TAX_AMOUNT")
	private BigDecimal stateTaxAmount;
	
	@Column(name="STATE_TAX_START_DATE")
	private Date stateTaxStartDate;
	
	@Column(name="STATE_TAX_END_DATE")
	private Date stateTaxEndDate;
	
	@Column(name="STATE_TAX_FLAG")
	private String stateTaxFlag;
	
	@Column(name="STATE_TAX_BALANCE_AMOUNT")
	private BigDecimal stateTaxBalanceAmount;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@OneToMany(mappedBy="vehicleStateTax",cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Set<Payment> payments;
	
	public BigDecimal getCurrentStatePaidAmount() {
		return currentStatePaidAmount;
	}

	public void setCurrentStatePaidAmount(BigDecimal currentStatePaidAmount) {
		this.currentStatePaidAmount = currentStatePaidAmount;
	}

	public Date getCurrentStatePaidDate() {
		return currentStatePaidDate;
	}

	public void setCurrentStatePaidDate(Date currentStatePaidDate) {
		this.currentStatePaidDate = currentStatePaidDate;
	}

	public long getVehicleStateTaxId() {
		return vehicleStateTaxId;
	}

	public void setVehicleStateTaxId(long vehicleStateTaxId) {
		this.vehicleStateTaxId = vehicleStateTaxId;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public BigDecimal getStateTaxAmount() {
		return stateTaxAmount;
	}

	public void setStateTaxAmount(BigDecimal stateTaxAmount) {
		this.stateTaxAmount = stateTaxAmount;
	}

	public Date getStateTaxStartDate() {
		return stateTaxStartDate;
	}

	public void setStateTaxStartDate(Date stateTaxStartDate) {
		this.stateTaxStartDate = stateTaxStartDate;
	}

	public Date getStateTaxEndDate() {
		return stateTaxEndDate;
	}

	public void setStateTaxEndDate(Date stateTaxEndDate) {
		this.stateTaxEndDate = stateTaxEndDate;
	}

	public String getStateTaxFlag() {
		return stateTaxFlag;
	}

	public void setStateTaxFlag(String stateTaxFlag) {
		this.stateTaxFlag = stateTaxFlag;
	}

	public BigDecimal getStateTaxBalanceAmount() {
		return stateTaxBalanceAmount;
	}

	public void setStateTaxBalanceAmount(BigDecimal stateTaxBalanceAmount) {
		this.stateTaxBalanceAmount = stateTaxBalanceAmount;
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

	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

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
