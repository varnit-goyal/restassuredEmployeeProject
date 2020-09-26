package com.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "23";

	public Logger logger;

	@BeforeClass
	public void setup() {

		
		  logger=logger.getLogger("EmployeesRestAPI");
			/* logger=logger.getLogger("TC001_Get_All_Employees.class"); */
		 

		PropertyConfigurator.configure(
				"C:\\Users\\Varnit.Goyal\\eclipse-workspace\\RestAssuredAPITesting_Employee_Project\\test-output\\Log4j.properties");
		logger.setLevel(Level.DEBUG);

	}

}
