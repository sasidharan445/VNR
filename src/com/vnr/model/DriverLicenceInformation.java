package com.vnr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DRIVER_LICENCE_INFORMATION")
public class DriverLicenceInformation  implements Serializable {
	private static final long serialVersionUID = -6557748142663694335L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DRIVER_LICENCE_INFORMATION_ID")
	private long driverLicenceInfomationId;
	
	@Column(name="LICENCE_NUMBER")
	private String licenceNumber;
	
	@Column(name="LICENCE_CLASS")
	private String licenceClass;
	
	@Column(name="EXPIRY_DATE")
	private Date expiryDate;
	
	@Column(name="ISSUED_DATE")
	private Date issuedDate;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	public long getDriverLicenceInfomationId() {
		return driverLicenceInfomationId;
	}

	public void setDriverLicenceInfomationId(long driverLicenceInfomationId) {
		this.driverLicenceInfomationId = driverLicenceInfomationId;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getLicenceClass() {
		return licenceClass;
	}

	public void setLicenceClass(String licenceClass) {
		this.licenceClass = licenceClass;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
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
