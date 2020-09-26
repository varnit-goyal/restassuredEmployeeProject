package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase {
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException{
		
		logger.info("*************started TC001_Get_All_Employees***");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1" ; 
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		Thread.sleep(3);
				}
@Test
void checkResponseBody() {
	
	logger.info("*************checking response body***");
	String responsebody=response.getBody().asString();
	logger.info("responsebody is"+responsebody);
	Assert.assertTrue(responsebody!=null);
}


@Test
void checkStatusCode() {
	
	logger.info("*************checking status code***");
	int statuscode=response.getStatusCode();
	logger.info("statuscode is"+statuscode);
	Assert.assertEquals(statuscode,200);
}



@Test
void checkResponseTime() {
	
	logger.info("*************checking response time***");
	long responseTime=response.getTime();
	logger.info("responseTime is"+responseTime);
	
	if(responseTime>2000)
		logger.warn("Response time is greater than 2000");
	
	Assert.assertTrue(responseTime<2000);
}




@Test
void checkStatusLine() {
	
	logger.info("*************checking status line***");
	String 	statusLine=response.getStatusLine();
	logger.info("statusline  is"+statusLine);
	Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
}
@Test
void checkContentType() {
	
	logger.info("*************checking Content Type***");
	String 	contentType=response.header("Content-Type");
	logger.info("contentType  is"+contentType);
	Assert.assertEquals(contentType,"application/json");
}
@Test
void checkServerType() {
	
	logger.info("*************checking server Type***");
	String 	serverType=response.header("Server");
	logger.info("serverType  is"+serverType);
	Assert.assertEquals(serverType,"nginx/1.16.0");
}
@Test
void checkContentEncoding() {
	
	logger.info("*************checking contentEncoding**");
	String 	contentEncoding=response.header("Content-Encoding");
	logger.info("contentEncoding  is"+contentEncoding);
	Assert.assertEquals(contentEncoding,"gzip");
}


@Test
void checkContentLength() {
	
	logger.info("*************checking contentlength**");
	String 	ContentLength=response.header("Content-Length");
	logger.info("ContentLength  is"+ContentLength);
	
	
	if(Integer.parseInt(ContentLength)<100)
		logger.warn("ContentLength  is less than 100");
		
	Assert.assertTrue(Integer.parseInt(ContentLength)>100);
}





@Test
void checkCookies() {
	
	logger.info("*************checking checkCookies**");
	String 	Cookies=response.getCookie("PHPSESSID");

	Assert.assertEquals(Cookies,"askldknklaskfn");
}



@AfterClass
void tearDown() {
	logger.info("*************finished TC001_Get_All_Employees***");
	
}


}
