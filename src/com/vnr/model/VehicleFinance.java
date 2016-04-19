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
@Table(name="VEHICLE_FINANCE")
public class VehicleFinance implements Serializable {

	private static final long serialVersionUID = 8888981332457493319L;
	
	transient private BigDecimal currentPaidAmount;
	transient private Date currentPaidDate;
	transient private String stateName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_FINANCE_ID")
	private long vehicleFinanceId;
	
	@Column(name="UNIT_NUMBER")
	private String unitNumber;
	
	@Column(name="CHILD_UNIT_NUMBER")
	private String childUnitNumber;
	
	@Column(name="FINANCE_COMPANY_NAME")
	private String financeCompanyName;
	
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;		
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE_CODE")
	private String stateCode;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="CONTACT_NAME")
	private String contactName; 
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber; 
	
	@Column(name="PRINCIPAL_AMOUNT")
	private BigDecimal principalAmount;
	
	@Column(name="LOAN_AMOUNT")
	private BigDecimal loanAmount;
	
	@Column(name="TOTAL_LOAN_AMOUNT")
	private BigDecimal totalLoanAmount;
	
	@Column(name="RATE_OF_INTEREST")
	private BigDecimal rateOfInterest;
	
	@Column(name="EMI_AMOUNT")
	private BigDecimal emiAmount;
	
	@Column(name="BALANCE_AMOUNT")
	private BigDecimal balanceAmount;
	
	@Column(name="LOAN_DUE_DATE")
	private Date loanDueDate;
	
	@Column(name="EMI_DUE_DATE")
	private Date emiDueDate;
	
	@Column(name="TOTAL_MONTHS")
	private BigDecimal numberOfMonths;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;
	
	@OneToMany(mappedBy="vehicleFinance",cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Set<Payment> payments;

	public long getVehicleFinanceId() {
		return vehicleFinanceId;
	}

	public void setVehicleFinanceId(long vehicleFinanceId) {
		this.vehicleFinanceId = vehicleFinanceId;
	}
	
	public String getFinanceCompanyName() {
		return financeCompanyName;
	}

	public void setFinanceCompanyName(String financeCompanyName) {
		this.financeCompanyName = financeCompanyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public BigDecimal getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getTotalLoanAmount() {
		return totalLoanAmount;
	}

	public void setTotalLoanAmount(BigDecimal totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}

	public BigDecimal getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(BigDecimal rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public BigDecimal getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(BigDecimal emiAmount) {
		this.emiAmount = emiAmount;
	}

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Date getLoanDueDate() {
		return loanDueDate;
	}

	public void setLoanDueDate(Date loanDueDate) {
		this.loanDueDate = loanDueDate;
	}

	public Date getEmiDueDate() {
		return emiDueDate;
	}

	public void setEmiDueDate(Date emiDueDate) {
		this.emiDueDate = emiDueDate;
	}

	public BigDecimal getNumberOfMonths() {
		return numberOfMonths;
	}

	public void setNumberOfMonths(BigDecimal numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
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
	
	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public BigDecimal getCurrentPaidAmount() {
		return currentPaidAmount;
	}

	public void setCurrentPaidAmount(BigDecimal currentPaidAmount) {
		this.currentPaidAmount = currentPaidAmount;
	}

	public Date getCurrentPaidDate() {
		return currentPaidDate;
	}

	public void setCurrentPaidDate(Date currentPaidDate) {
		this.currentPaidDate = currentPaidDate;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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
