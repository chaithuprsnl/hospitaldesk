package com.hospital.fdesk.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.fdesk.exception.InvalidInputException;
import com.hospital.fdesk.model.Appointment;
import com.hospital.fdesk.model.Specialist;
import com.hospital.fdesk.service.HospitalFdeskService;

@RestController
@RequestMapping("${com.fdesk.rootURI}")
public class HospitalFdeskController {

	private Logger logger = LoggerFactory.getLogger(HospitalFdeskController.class);

	@Autowired
	HospitalFdeskService service;

	@GetMapping(value = "${com.fdesk.getspecialistURI}")
	public ResponseEntity<List<Specialist>> getSpecialistDetails(@PathVariable("hospital") String hospitalName,
			@PathVariable("type") String specialistType) throws InvalidInputException {
		List<Specialist> specialistList = service.getSpecialistDetails(hospitalName, specialistType);
		return new ResponseEntity<List<Specialist>>(specialistList, HttpStatus.OK);
	}

	@PostMapping("${com.fdesk.createAppointment}")
	public ResponseEntity<Appointment> createAppointment(@PathVariable("docname") String doctorName,
			@PathVariable("day") String appointmentDay, @PathVariable("patientname") String patientName)
			throws InvalidInputException {
		Appointment appointment = service.createAppointment(doctorName, appointmentDay, patientName);
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

	@GetMapping(value = "${com.fdesk.getBedsURI}")
	public ResponseEntity<String> getBedsAvailability(@PathVariable("hospital") String hospitalName)
			throws InvalidInputException {
		Long beds = service.getBedsAvailability(hospitalName);
		return new ResponseEntity<String>("Number of Beds Available is = " + beds, HttpStatus.OK);
	}
}
