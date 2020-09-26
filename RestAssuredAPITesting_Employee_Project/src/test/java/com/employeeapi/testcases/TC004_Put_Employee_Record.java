package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Put_Employee_Record extends TestBase{

	RequestSpecification httpRequest;
	Response response;
	String empName=RestUtils.empName();
	String empSalary=RestUtils.empSal();
	String empAge=RestUtils.empAge();
	

		@BeforeClass
		void updateEmployees() throws InterruptedException{
			
			logger.info("*************started TC004_Put_Employee_Record***");
			RestAssured.baseURI="http://dummy.restapiexample.com/api/v1" ; 
			httpRequest=RestAssured.given();
			
			
		JSONObject requestParam=new JSONObject();
		requestParam.put("name",empName);
		requestParam.put("salary",empSalary);
		requestParam.put("age",empAge);
		
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParam.toJSONString());
		
			response=httpRequest.request(Method.PUT,"/update/"+empID);
			Thread.sleep(5000);
					}
	@Test
	void checkResponseBody() {
		
	String responsebody=response.getBody().asString();
		Assert.assertEquals(responsebody.contains(empName),true);
		Assert.assertEquals(responsebody.contains(empSalary),true);
		Assert.assertEquals(responsebody.contains(empAge),true);
	}


	@Test
	void checkStatusCode() {
		int statuscode=response.getStatusCode();
	Assert.assertEquals(statuscode,200);
	}



	@Test
	void checkResponseTime() {
		long responseTime=response.getTime();
		
		Assert.assertTrue(responseTime<2000);
	}




	@Test
	void checkStatusLine() {
		String 	statusLine=response.getStatusLine();

		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}
	@Test
	void checkContentType() {
		
		
		String 	contentType=response.header("Content-Type");

		Assert.assertEquals(contentType,"application/json");
	}
	@Test
	void checkServerType() {
		
		
		String 	serverType=response.header("Server");

		Assert.assertEquals(serverType,"nginx/1.16.0");
	}

	@Test
	void checkContentLength() {
		

		String 	ContentLength=response.header("Content-Length");
		
			
		Assert.assertTrue(Integer.parseInt(ContentLength)<1500);
	}



	@AfterClass
	void tearDown() {
		logger.info("*****finished*******TC004_Put_Employee_Record***");
		
	}


	}




