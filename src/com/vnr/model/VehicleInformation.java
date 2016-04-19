package com.vnr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(
	name = "SELECT_ACTIVE_VEHICLES",
	query = "from VehicleInformation vi where (vi.unitNumber not in (select distinct unitNumber from VehicleFinance)" +
			" or vi.unitNumber not in (select distinct childUnitNumber from VehicleFinance) )" +
			" and vi.vehicleStatus = 'Active'"
	)
})

@Entity
@Table(name="VEHICLE_INFORMATION")
public class VehicleInformation  implements Serializable {

	private static final long serialVersionUID = -892344929088764782L;

	transient String submitAction;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_INFORMATION_ID")
	private Long vehicleInformationId;
	
	@Column(name="UNIT_NUMBER")
	private String unitNumber;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	
	@Column(name="LOGISTIC_MODE")
	private String logisticMode;
	
	@Column(name="REGISTRATION_NUMBER")
	private String registrationNumber;
	
	@Column(name="VEHICLE_STATUS")
	private String vehicleStatus;
	
	@Column(name="VEHICLE_MAKE")
	private String vehicleMake;
	
	@Column(name="VEHICLE_MODEL")
	private String vehicleModel;
	
	@Column(name="VEHICLE_MODEL_YEAR")
	private String vehicleModelYear;
	
	@Column(name="VEHICLE_ENGINE_NUMBER")
	private String vehicleEngineNumber;
	
	@Column(name="VEHICLE_CHASSIS_NUMBER")
	private String vehicleChassisNumber;
	
	@Column(name="VEHICLE_NUM_OF_TYRES")
	private Long vehicleNumOfTyres;
	
	@Column(name="VEHICLE_LENGTH")
	private Float vehicleLength;
		
	@Column(name="VEHICLE_HAULING_CAPACITY")
	private Long vehicleHaulingCapacity;
	
	@Column(name="VEHICLE_HAULING_TYPE")
	private String vehicleHaulingType;
		
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	public String getSubmitAction() {
		return submitAction;
	}

	public void setSubmitAction(String submitAction) {
		this.submitAction = submitAction;
	}

	public Long getVehicleInformationId() {
		return vehicleInformationId;
	}

	public void setVehicleInformationId(Long vehicleInformationId) {
		this.vehicleInformationId = vehicleInformationId;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getLogisticMode() {
		return logisticMode;
	}

	public void setLogisticMode(String logisticMode) {
		this.logisticMode = logisticMode;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleModelYear() {
		return vehicleModelYear;
	}

	public void setVehicleModelYear(String vehicleModelYear) {
		this.vehicleModelYear = vehicleModelYear;
	}

	public String getVehicleEngineNumber() {
		return vehicleEngineNumber;
	}

	public void setVehicleEngineNumber(String vehicleEngineNumber) {
		this.vehicleEngineNumber = vehicleEngineNumber;
	}

	public String getVehicleChassisNumber() {
		return vehicleChassisNumber;
	}

	public void setVehicleChassisNumber(String vehicleChassisNumber) {
		this.vehicleChassisNumber = vehicleChassisNumber;
	}

	public Long getVehicleNumOfTyres() {
		return vehicleNumOfTyres;
	}

	public void setVehicleNumOfTyres(Long vehicleNumOfTyres) {
		this.vehicleNumOfTyres = vehicleNumOfTyres;
	}

	public Float getVehicleLength() {
		return vehicleLength;
	}

	public void setVehicleLength(Float vehicleLength) {
		this.vehicleLength = vehicleLength;
	}
	
	public Long getVehicleHaulingCapacity() {
		return vehicleHaulingCapacity;
	}

	public void setVehicleHaulingCapacity(Long vehicleHaulingCapacity) {
		this.vehicleHaulingCapacity = vehicleHaulingCapacity;
	}

	public String getVehicleHaulingType() {
		return vehicleHaulingType;
	}

	public void setVehicleHaulingType(String vehicleHaulingType) {
		this.vehicleHaulingType = vehicleHaulingType;
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
