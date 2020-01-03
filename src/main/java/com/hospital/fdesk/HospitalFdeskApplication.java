package com.hospital.fdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.hospital.fdesk.service.SpecialistProperties;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties(SpecialistProperties.class)
@PropertySources(value={@PropertySource("classpath:specialist.properties")})
public class HospitalFdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalFdeskApplication.class, args);
	}

}

