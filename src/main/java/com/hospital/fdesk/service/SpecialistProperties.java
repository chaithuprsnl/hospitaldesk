package com.hospital.fdesk.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;

@ConstructorBinding
@ConfigurationProperties(prefix="com.specialist")
public class SpecialistProperties {
	
	/**
	 * Name of the specialist
	 */
	private String name;
	
	/**
	 * Specialist available day
	 */
	private String availableDay;
	
	/**
	 * Specialist available time
	 */
	private String availableTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvailableDay() {
		return availableDay;
	}
	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public SpecialistProperties(String name, String availableDay, String availableTime) {
		super();
		this.name = name;
		this.availableDay = availableDay;
		this.availableTime = availableTime;
	}
	
	
}
