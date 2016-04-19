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
@Table(name="VEHICLE_INSURANCE")
public class VehicleInsurance  implements Serializable {

	private static final long serialVersionUID = 5781431149290767109L;
	transient private BigDecimal currentInsurancePaidAmount;
	transient private Date currentInsurancePaidDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_INSURANCE_ID")
	private long vehicleInsuranceId;
	
	@Column(name="UNIT_NUMBER")
	private String unitNumber;
	
	@Column(name="CHILD_UNIT_NUMBER")
	private String childUnitNumber;
		
	@Column(name="INSURANCE_AMOUNT")
	private BigDecimal insuranceAmount;
	
	@Column(name="INSURANCE_START_DATE")
	private Date insuranceStartDate;
	
	@Column(name="INSURANCE_END_DATE")
	private Date insuranceEndDate;
	
	@Column(name="INSURANCE_FLAG")
	private String insuranceFlag;
	
	@Column(name="INSURANCE_BALANCE_AMOUNT")
	private BigDecimal insuranceBalanceAmount;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;
	
	@OneToMany(mappedBy="vehicleInsurance", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    private Set<Payment> payments;

	public BigDecimal getCurrentInsurancePaidAmount() {
		return currentInsurancePaidAmount;
	}

	public void setCurrentInsurancePaidAmount(BigDecimal currentInsurancePaidAmount) {
		this.currentInsurancePaidAmount = currentInsurancePaidAmount;
	}

	public Date getCurrentInsurancePaidDate() {
		return currentInsurancePaidDate;
	}

	public void setCurrentInsurancePaidDate(Date currentInsurancePaidDate) {
		this.currentInsurancePaidDate = currentInsurancePaidDate;
	}

	public long getVehicleInsuranceId() {
		return vehicleInsuranceId;
	}

	public void setVehicleInsuranceId(long vehicleInsuranceId) {
		this.vehicleInsuranceId = vehicleInsuranceId;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}	

	public BigDecimal getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(BigDecimal insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public Date getInsuranceStartDate() {
		return insuranceStartDate;
	}

	public void setInsuranceStartDate(Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}

	public Date getInsuranceEndDate() {
		return insuranceEndDate;
	}

	public void setInsuranceEndDate(Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}

	public String getInsuranceFlag() {
		return insuranceFlag;
	}

	public void setInsuranceFlag(String insuranceFlag) {
		this.insuranceFlag = insuranceFlag;
	}

	public BigDecimal getInsuranceBalanceAmount() {
		return insuranceBalanceAmount;
	}

	public void setInsuranceBalanceAmount(BigDecimal insuranceBalanceAmount) {
		this.insuranceBalanceAmount = insuranceBalanceAmount;
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
