package com.org.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import APIFrame.constants.EndPoints;
import APIFrame.helpers.EmployeeServiceHelper;
import APIFrame.model.Employee;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiAutomation {

	static Logger logger = Logger.getLogger(RestApiAutomation.class.getName());
	 private EmployeeServiceHelper employeeServiceHelper;
	 
	  @BeforeMethod()
      public void init(){
		  employeeServiceHelper = new EmployeeServiceHelper();
		  logger.info("******************Rest API Automation started for test****************** ");
      }
	  
	  @Test
      public void testGetAllEmployee(){
		  logger.info("This is testGetAllEmployee Test ");
		  logger.info("Get All Employee Response Status check "+employeeServiceHelper.getAllEmployee());
              assertEquals(employeeServiceHelper.getAllEmployee(),HttpStatus.SC_OK);
      }
	  
		@Test
		public void GetSingleEmployeeData() {
			logger.info("This is functionality check for retreving the single employee data");
			JsonPath jsonPathEvaluator=employeeServiceHelper.getSingleEmployee(1);
	 		logger.info("# Status message is : "+jsonPathEvaluator.get("status"));
	 		logger.info("# Employee id is : "+jsonPathEvaluator.get("data.id"));
	 		logger.info("# Employee Name is : "+jsonPathEvaluator.get("data.employee_name"));
	 		logger.info("# Employee Salary is : "+jsonPathEvaluator.get("data.employee_salary"));
	 		logger.info("# Employee Age is : "+jsonPathEvaluator.get("data.employee_age"));
	 		assertEquals(jsonPathEvaluator.get("data.id"),1);
	 		assertEquals(jsonPathEvaluator.get("data.employee_name"),"Tiger Nixon");
	 		assertEquals(jsonPathEvaluator.get("data.employee_salary"),320800);
	 		assertEquals(jsonPathEvaluator.get("data.employee_age"),61);
		}
		@Test
		 public void CreateEmployee()
		 {
			logger.info("This is functionality check for creating an employee");
			 RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/create";
			 RequestSpecification request = RestAssured.given();
			 
			 JSONObject requestParams = new JSONObject();
			 requestParams.put("employee_name","test");
			 requestParams.put("employee_salary","123");
			 requestParams.put("employee_age","23");
			
			 request.header("Content-Type", "application/json");
			 request.body(requestParams.toString());
			 
			 		Response response= request.post(RestAssured.baseURI);
			 		String str=response.getBody().asString();
			 		System.out.println(str);  
			 		Gson g = new Gson();  
			 		Employee s = g.fromJson(str, Employee.class);  
			 		JSONObject jObject = new JSONObject(str);
			 		JSONObject geoObject = jObject.getJSONObject("data");
			 		
			 		logger.info("# New Employee ID created is : "+ geoObject.getInt("id"));
			       	logger.info("# New Employee Name created is : "+ geoObject.getString("employee_name")); 
			       	logger.info("# New employee_age created is : "+ geoObject.getInt("employee_age"));
			       	logger.info("# New employee_salary created is : "+ geoObject.getInt("employee_salary"));
			 		 
			    assertEquals(response.getStatusCode(), HttpStatus.SC_OK);   	
			 	assertEquals(geoObject.getString("employee_name"),"test");
			 	assertEquals(geoObject.getString("employee_age"),"23");
			 	assertEquals(geoObject.getString("employee_salary"),"123");
		 }
	  
	  
}