package com.hospital.fdesk.model;

import java.util.List;

/**
 * @author 493163
 *
 */
public class Hospital {

	private Integer hospitalId;
	private String hospitalName;
	private Long numberOfBeds;
	private List<PatientStatus> patientStatus;

	/**
	 * @param hospitalId
	 * @param hospitalName
	 * @param numberOfBeds
	 * @param patientStatus
	 */
	public Hospital(Integer hospitalId, String hospitalName, Long numberOfBeds, List<PatientStatus> patientStatus) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.numberOfBeds = numberOfBeds;
		this.patientStatus = patientStatus;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public Long getNumberOfBeds() {
		return numberOfBeds;
	}

	/*public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public void setNumberOfBeds(Long numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public void setPatientStatus(List<PatientStatus> patientStatus) {
		this.patientStatus = patientStatus;
	}*/

	public List<PatientStatus> getPatientStatus() {
		return patientStatus;
	}

}
