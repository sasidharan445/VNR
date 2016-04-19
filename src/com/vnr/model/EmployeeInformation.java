package com.vnr.model;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_INFORMATION")
public class EmployeeInformation implements Serializable {

	private static final long serialVersionUID = -3019959369973191902L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_INFORMATION_ID")
	private long employeeInformationId;
	
	@Column(name="EMPLOYEE_TYPE")
	private String employeeType;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employeeInformation", cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employeeInformation", cascade = CascadeType.ALL)
	private DriverLicenceInformation driverLicenceInformation;		
	
	@OneToMany(mappedBy="employeeInformation",cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Set<EmployeeIdProofDocument> emplyEmployeeIdProofDocuments;
	
	@Column(name="EMPLOYEE_STATUS")
	private String employeeStatus;
	
	@Column(name="REFERENCE_NAME")
	private String referenceName;
	
	@Column(name="REFERENCE_CONTACT_NUMBER")
	private String referenceContactNumber;
	
	@Column(name="EMPLOYEE_CONTACT_NUMBER")
	private String employeeContactNumber;
	
	@Column(name="EMPLOYEE_EMERCY_CONTACT_NAME")
	private String employeeEmercyContactName;
	
	@Column(name="EMPLOYEE_EMERCY_CONTACT_NUMBER")
	private String employeeEmercyContactNumber;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	public long getEmployeeInformationId() {
		return employeeInformationId;
	}

	public void setEmployeeInformationId(long employeeInformationId) {
		this.employeeInformationId = employeeInformationId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DriverLicenceInformation getDriverLicenceInformation() {
		return driverLicenceInformation;
	}

	public void setDriverLicenceInformation(
			DriverLicenceInformation driverLicenceInformation) {
		this.driverLicenceInformation = driverLicenceInformation;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getReferenceContactNumber() {
		return referenceContactNumber;
	}

	public void setReferenceContactNumber(String referenceContactNumber) {
		this.referenceContactNumber = referenceContactNumber;
	}

	public String getEmployeeContactNumber() {
		return employeeContactNumber;
	}

	public void setEmployeeContactNumber(String employeeContactNumber) {
		this.employeeContactNumber = employeeContactNumber;
	}

	public String getEmployeeEmercyContactName() {
		return employeeEmercyContactName;
	}

	public void setEmployeeEmercyContactName(String employeeEmercyContactName) {
		this.employeeEmercyContactName = employeeEmercyContactName;
	}

	public String getEmployeeEmercyContactNumber() {
		return employeeEmercyContactNumber;
	}

	public void setEmployeeEmercyContactNumber(String employeeEmercyContactNumber) {
		this.employeeEmercyContactNumber = employeeEmercyContactNumber;
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
	
	
}
