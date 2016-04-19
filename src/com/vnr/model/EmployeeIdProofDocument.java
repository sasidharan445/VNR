package com.vnr.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_ID_PROOF_DOCUMENT")
public class EmployeeIdProofDocument  implements Serializable {

	
	private static final long serialVersionUID = 9178670134480482646L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID_PROOF_DOCUMENT_ID")
	private long employeeIdProofDocumentId;
	
	@Column(name="DOCUMENT_TYPE")
	private String documentType;
	
	@Column(name="DOCUMENT_FILE_NAME")
	private String documentFileName;
	
	@Column(name="DOCUMENT")
	private Blob document;
	
	@Column(name="DOCUMENT_FILE_TYPE")
	private String documentFileType;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_INFORMATION_ID")
	private EmployeeInformation employeeInformation;

	public long getEmployeeIdProofDocumentId() {
		return employeeIdProofDocumentId;
	}

	public void setEmployeeIdProofDocumentId(long employeeIdProofDocumentId) {
		this.employeeIdProofDocumentId = employeeIdProofDocumentId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentFileName() {
		return documentFileName;
	}

	public void setDocumentFileName(String documentFileName) {
		this.documentFileName = documentFileName;
	}

	public Blob getDocument() {
		return document;
	}

	public void setDocument(Blob document) {
		this.document = document;
	}

	public String getDocumentFileType() {
		return documentFileType;
	}

	public void setDocumentFileType(String documentFileType) {
		this.documentFileType = documentFileType;
	}

	public EmployeeInformation getEmployeeInformation() {
		return employeeInformation;
	}

	public void setEmployeeInformation(EmployeeInformation employeeInformation) {
		this.employeeInformation = employeeInformation;
	}
	
	
}
