package com.vnr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATE_REF")
public class StateRef {
	
	@Id	
	@Column(name="STATE_CODE")
	private String stateCode;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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
