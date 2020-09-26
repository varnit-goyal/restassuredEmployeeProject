package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Get_Single_Employee_Record extends TestBase{

RequestSpecification httpRequest;
Response response;

	@BeforeClass
	void getAllEmployees() throws InterruptedException{
		
		logger.info("*************started TC002_Get_Single_Employee_Record***");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1" ; 
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employee/"+empID);
		Thread.sleep(3000);
				}
@Test
void checkResponseBody() {
	
String responsebody=response.getBody().asString();
	Assert.assertEquals(responsebody.contains(empID),true);
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
	logger.info("*************TC002_Get_Single_Employee_Record***");
	
}


}




