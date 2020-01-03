package com.hospital.fdesk.model;

import java.util.List;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Produces(value={"application/xml", "application/json"})
@JacksonXmlRootElement
@XmlRootElement
public class Specialists {

	private List<Specialist> specialists;

	public Specialists(List<Specialist> specialists) {
		super();
		this.specialists = specialists;
	}
	
	public Specialists(){
		super();
	}

	public List<Specialist> getSpecialists() {
		return specialists;
	}

	public void setSpecialists(List<Specialist> specialists) {
		this.specialists = specialists;
	}
	
	
}
