package com.health.care.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.health.care.db.Dependents;
import com.health.care.db.HealthEntity;
import com.health.care.service.EnrollService;
import com.health.care.starter.EnrollController;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = EnrollController.class)
public class EnrollControllerTest {

	@MockBean
	private EnrollService enrollService;
	
	Dependents dependents=new Dependents(1,"D1","25/11/1988");
	List<Dependents> listDependents = new ArrayList<Dependents>(); 
	HealthEntity healthEntity = new HealthEntity(10L,"NAN",true,listDependents, "9876523415","25/11/1986");
	
	
	String healthCareJson = "{\"id\":11,\"name\": \"NAN\",\"activationStatus\":true,\"dependents\": [{\"name\":\"A\",\"dateOfBirth\":\"1989-09-05\"}],\"phoneNumber\":\"9876523415\",\"dateOfBirth\":\"1988-11-25\"";
	
	String output = "Created";

	@Test
	public void createHealthCare() throws Exception {

		Mockito.when(
				enrollService.enrollHealthCare(Mockito.anyObject())).thenReturn(healthEntity);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/enrollHealthCare").accept(
				MediaType.APPLICATION_JSON);
		
		String result = requestBuilder.toString();

		JSONAssert.assertEquals(result, output, true);
	}
	
	@Test
	public void updateHealthCare() throws Exception {

		Mockito.when(
				enrollService.updateEnrollHealthCare(Mockito.anyObject())).thenReturn(healthEntity);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/modifyEnrollHealthCare").accept(
				MediaType.APPLICATION_JSON);
		
		String result = requestBuilder.toString();

		JSONAssert.assertEquals(result, output, true);
	}
	
	@Test
	public void deleteHealthCare() throws Exception {

		Mockito.when(
				enrollService.removeEnrollHealthCare(Mockito.anyObject())).thenReturn(healthEntity);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/removeEnrollHealthCare").accept(
				MediaType.APPLICATION_JSON);
		
		String result = requestBuilder.toString();

		JSONAssert.assertEquals(result, output, true);
	}

}
