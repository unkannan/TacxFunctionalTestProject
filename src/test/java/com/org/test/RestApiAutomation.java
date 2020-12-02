package com.org.test;

import static org.testng.Assert.assertEquals;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import APIFrame.constants.APIResponseMessages;
import APIFrame.helpers.EmployeeServiceHelper;
import io.restassured.path.json.JsonPath;

public class RestApiAutomation {

	static Logger logger = Logger.getLogger(RestApiAutomation.class.getName());
	private EmployeeServiceHelper employeeServiceHelper;

	@BeforeMethod()
	public void init() {
		employeeServiceHelper = new EmployeeServiceHelper();
		logger.info("******************Rest API Automation started for test****************** ");
	}

	 @Test
	public void testGetAllEmployee() {
		logger.info("****************************This is testGetAllEmployee Test ****************************");
		logger.info("# Get All Employee Response Status check : " + employeeServiceHelper.getAllEmployee());
		assertEquals(employeeServiceHelper.getAllEmployee(), HttpStatus.SC_OK);
		logger.info("*********************************************************************************************\n");
	}

	 @Test
	public void GetSingleEmployeeData() {
		logger.info("*************************************This is functionality check for retreving the single employee data*************************");
		JsonPath jsonPathEvaluator = employeeServiceHelper.getSingleEmployee(1);
		logger.info("# Status message is : " + jsonPathEvaluator.get("status"));
		logger.info("# Employee id is : " + jsonPathEvaluator.get("data.id"));
		logger.info("# Employee Name is : " + jsonPathEvaluator.get("data.employee_name"));
		logger.info("# Employee Salary is : " + jsonPathEvaluator.get("data.employee_salary"));
		logger.info("# Employee Age is : " + jsonPathEvaluator.get("data.employee_age"));
		assertEquals(jsonPathEvaluator.get("data.id"), 1);
		assertEquals(jsonPathEvaluator.get("data.employee_name"), "Tiger Nixon");
		assertEquals(jsonPathEvaluator.get("data.employee_salary"), 320800);
		assertEquals(jsonPathEvaluator.get("data.employee_age"), 61);
		logger.info("*********************************************************************************************\n");
	}

	@Test
	public void CreateEmployee() {
		// Creating an input data to create the employee
		logger.info("**************************This is functionality check for creating a new employee***********************");
		JSONObject requestParams = new JSONObject();
		requestParams.put("employee_name", "test");
		requestParams.put("employee_salary", "123");
		requestParams.put("employee_age", "23");

		// service called to create the employee
		String str = employeeServiceHelper.createEmployee(requestParams.toString());

		// validation of jason response
		JSONObject jObject = new JSONObject(str);
		logger.info("# API Response Status for create Record :" + jObject.getString("status"));
		logger.info("# API Response delete confirm message : " + jObject.getString("message"));
		assertEquals(jObject.getString("status"), APIResponseMessages.success);
		assertEquals(jObject.getString("message"), APIResponseMessages.NewRecordSucessMessage);

		JSONObject geoObject = jObject.getJSONObject("data");
		logger.info("# New Employee ID created is : " + geoObject.getInt("id"));
		logger.info("*********************************************************************************************\n");
	}

	 @Test
	public void updateEmployee() {
		logger.info("******************This is functionality check for Updating an employee with given id*********************");
		// Updating the details for existing record 23
		JSONObject requestParams = new JSONObject();
		requestParams.put("employee_name", "test");
		requestParams.put("employee_salary", "123");
		requestParams.put("employee_age", "23");

		// update employee service is called by sedning the json string and id
		String str = employeeServiceHelper.UpdateEmployee(requestParams.toString(), 21);

		// Response is caught in a string and trying to extract using json object
		JSONObject jObject = new JSONObject(str);
		logger.info("# API Response Status for Updated Record :" + jObject.getString("status"));
		logger.info("# API Response message for Updated record: " + jObject.getString("message"));

		// verifying the response status and the message
		assertEquals(jObject.getString("status"), APIResponseMessages.success);
		assertEquals(jObject.getString("message"), APIResponseMessages.UpdateRecordConfirmMessage);
		logger.info("*********************************************************************************************\n");
	}

	@Test
	public void deleteEmployee() {
		// employee service herlper rest api is called for deleting the employee record
		// id 719
		logger.info("************************This is functionality check for deleting an employee*************************************");
		String str = employeeServiceHelper.DeleteEmployee(719);
		JSONObject jObject = new JSONObject(str);
		logger.info("# API Response Status for Delete Record :" + jObject.getString("status"));
		logger.info("# API Response delete confirm message : " + jObject.getString("message"));

		// verifying the response status and the message
		assertEquals(jObject.getString("status"), APIResponseMessages.success);
		assertEquals(jObject.getString("message"), APIResponseMessages.DeleteRecordConfirmMessage);
		logger.info("*********************************************************************************************\n");
	}

}