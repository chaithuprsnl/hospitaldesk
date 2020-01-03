package com.hospital.fdesk.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hospital.fdesk.exception.InvalidInputException;
import com.hospital.fdesk.model.Appointment;
import com.hospital.fdesk.model.Hospital;
import com.hospital.fdesk.model.PatientStatus;
import com.hospital.fdesk.model.Specialist;

@Service
public class HospitalFdeskService {

	private Logger logger = LoggerFactory.getLogger(HospitalFdeskService.class);

	private Map<Long, Specialist> specialistMap = new HashMap<>();
	private List<Hospital> hospitalList = new ArrayList<>();

	private List<Specialist> resultList = new ArrayList<>();

	@Autowired
	private SpecialistProperties specialistProperties;

	public HospitalFdeskService() {

		Specialist specialist1 = new Specialist("Sandhya", "Dentist", "Monday,Wednesday", "5 to 6", "Y", 946);
		specialistMap.put(1L, specialist1);

		Specialist specialist2 = new Specialist("Saranya", "Dentist", "Thursday", "6 to 8", "Y", 946);
		specialistMap.put(2L, specialist2);
		
		Specialist specialist3 = new Specialist("Stephen", "Cardiologist", "Tuesday,Thursday,Saturday", "5 to 10", "Y", 947);
		specialistMap.put(3L, specialist3);
		
		Specialist specialist4 = new Specialist("Prashant", "Opthamologist", "Monday,Tuesday,Wednesday,Thursday", "6 to 7", "Y", 948);
		specialistMap.put(4L, specialist4);
		
		Specialist specialist5 = new Specialist("Ramkumar", "Dermotologist", "Monday,Wednesday,Friday", "10 to 12", "Y", 949);
		specialistMap.put(5L, specialist5);

		PatientStatus[] patientStatus1 = { PatientStatus.DISCHARGE, PatientStatus.DISCHARGE, PatientStatus.DISCHARGE,
				PatientStatus.JOINED };
		List<PatientStatus> hospital1PatiestList = Arrays.asList(patientStatus1);

		Hospital hospital1 = new Hospital(946, "Global Hospitals", 10L, hospital1PatiestList);
		hospitalList.add(hospital1);

		PatientStatus[] patientStatus2 = { PatientStatus.JOINED, PatientStatus.JOINED, PatientStatus.JOINED,
				PatientStatus.JOINED, PatientStatus.JOINED };
		List<PatientStatus> hospital2PatiestList = Arrays.asList(patientStatus2);

		Hospital hospital2 = new Hospital(947, "Apollo Hospitals", 5L, hospital2PatiestList);
		hospitalList.add(hospital2);

		PatientStatus[] patientStatus3 = { PatientStatus.JOINED, PatientStatus.JOINED, PatientStatus.DISCHARGE,
				PatientStatus.JOINED };
		List<PatientStatus> hospital3PatiestList = Arrays.asList(patientStatus3);

		Hospital hospital3 = new Hospital(948, "KIMS Hospitals", 8L, hospital3PatiestList);
		hospitalList.add(hospital3);

		PatientStatus[] patientStatus4 = { PatientStatus.JOINED, PatientStatus.JOINED, PatientStatus.JOINED,
				PatientStatus.JOINED };
		List<PatientStatus> hospital4PatiestList = Arrays.asList(patientStatus4);

		Hospital hospital4 = new Hospital(949, "Fortis Hospitals", 20L, hospital4PatiestList);
		hospitalList.add(hospital4);

	}

	@Cacheable("resultList")
	public List<Specialist> getSpecialistDetails(String hospitalName, String specialistType)
			throws InvalidInputException {

		logger.debug("hospital: " + hospitalName + " type: " + specialistType);
		if (hospitalList.stream().anyMatch(hospital -> hospital.getHospitalName().equals(hospitalName))) {

			Hospital hospital = hospitalList.stream().filter(hosp -> hosp.getHospitalName().equals(hospitalName))
					.findAny().orElse(null);

			List<Specialist> specialistList = new ArrayList<>(specialistMap.values());

			resultList = specialistList.stream()
					.filter(specialist -> specialist.getHospitalId().equals(hospital.getHospitalId())
							&& specialist.getSpecialistType().equals(specialistType))
					.collect(Collectors.toList());
			if(resultList.size() == 0)
				throw new InvalidInputException("No Specialist available with type: "+specialistType);

		} else {
			throw new InvalidInputException("Invalid Hospital Name: "+hospitalName);
		}
		logger.debug("Result List: " + resultList);
		return resultList;
	}

	public Appointment createAppointment(String doctorName, String appointmentDay, String patientName)
			throws InvalidInputException {

		Appointment appointment;

		logger.debug("Doctor in props: " + specialistProperties.getName() + " available day: "
				+ specialistProperties.getAvailableDay() + " time: " + specialistProperties.getAvailableTime());

		if (doctorName.equals(specialistProperties.getName())) {
			if (specialistProperties.getAvailableDay().indexOf(appointmentDay) != -1) {
				appointment = new Appointment(doctorName, patientName, appointmentDay,
						specialistProperties.getAvailableTime());
			} else {
				throw new InvalidInputException("Doctor is unavailable on the given day");
			}
		} else {
			throw new InvalidInputException("Invalid Doctor Name");
		}

		return appointment;
	}

	public Long getBedsAvailability(String hospitalName) throws InvalidInputException {

		if (hospitalList.stream().anyMatch(hospital -> hospital.getHospitalName().equals(hospitalName))) {
			Hospital hospital = hospitalList.stream().filter(hosp -> hosp.getHospitalName().equals(hospitalName))
					.findAny().orElse(null);
			Long total_beds = hospital.getNumberOfBeds();
			Long occupied_beds = hospital.getPatientStatus().stream()
					.filter(status -> status.name().equals("JOINED")).count();
			Long available_beds = total_beds - occupied_beds;
			if(available_beds == 0)
				throw new InvalidInputException("No beds are available for admission");
			else
				return available_beds;
		} else {
			throw new InvalidInputException("Invalid Hospital Name");
		}
	}
}
