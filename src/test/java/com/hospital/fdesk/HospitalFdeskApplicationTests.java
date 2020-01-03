package com.hospital.fdesk;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = HospitalFdeskApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HospitalFdeskApplicationTests {

	@LocalServerPort
	private int port;

	RestTemplate restTemplate = new RestTemplate();

	@Value("${com.fdesk.testURL}")
	private String contentURI;
	
	@Value("${com.fdesk.wrongInputURL}")
	private String wrongHospitalURL;

	@Test
	public void testGetSpecialistDetailsXml() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept","application/xml");
		
		HttpEntity entity = new HttpEntity(null, headers);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + contentURI, HttpMethod.GET, entity, String.class);
		assertThat(response.getStatusCodeValue(), is(200));

	}
	
	@Test
	public void testGetSpecialistDetailsJson() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept","application/json");
		
		HttpEntity entity = new HttpEntity(null, headers);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + contentURI, HttpMethod.GET, entity, String.class);
		assertThat(response.getStatusCodeValue(), is(200));

	}
	
	@Test(expected = HttpClientErrorException.class)
	public void testGetSpecialistDetailsJsonWrongInput() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept","application/json");
		
		HttpEntity entity = new HttpEntity(null, headers);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + wrongHospitalURL, HttpMethod.GET, entity, String.class);
		assertThat(response.getStatusCodeValue(), is(200));

	}

}