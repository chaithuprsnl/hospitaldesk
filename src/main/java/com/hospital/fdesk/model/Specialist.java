package com.hospital.fdesk.model;

import javax.ws.rs.Produces;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author 493163
 *
 */
@Produces(value={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
@JacksonXmlRootElement
public class Specialist {

	@JacksonXmlProperty
	private String specialistName;

	@JacksonXmlProperty
	private String specialistType;

	@JacksonXmlProperty
	private String availableDay;

	@JacksonXmlProperty
	private String availableTime;

	@JacksonXmlProperty
	private String isAvailable;

	@JacksonXmlProperty
	private Integer hospitalId;

	/**
	 * @param specialistName
	 * @param specialistType
	 * @param availableDay
	 * @param availableTime
	 * @param isAvailable
	 * @param hospitalId
	 */
	public Specialist(String specialistName, String specialistType, String availableDay, String availableTime,
			String isAvailable, Integer hospitalId) {
		super();
		this.specialistName = specialistName;
		this.specialistType = specialistType;
		this.availableDay = availableDay;
		this.availableTime = availableTime;
		this.isAvailable = isAvailable;
		this.hospitalId = hospitalId;
	}
	
	/*public Specialist(){
		super();
	}*/
	
	public String getAvailableDay() {
		return availableDay;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public String getSpecialistName() {
		return specialistName;
	}

	public String getSpecialistType() {
		return specialistType;
	}

	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}

	public void setSpecialistType(String specialistType) {
		this.specialistType = specialistType;
	}

	@Override
	public String toString() {
		return "Specialist [specialistName=" + specialistName + ", specialistType=" + specialistType + ", availableDay="
				+ availableDay + ", availableTime=" + availableTime + ", isAvailable=" + isAvailable + ", hospitalId="
				+ hospitalId + "]";
	}

}
