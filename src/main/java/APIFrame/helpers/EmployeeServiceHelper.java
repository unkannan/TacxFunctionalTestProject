package APIFrame.helpers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import java.util.Properties;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import com.org.utility.ConfigFileReader;
import APIFrame.constants.EndPoints;

public class EmployeeServiceHelper {// We need to read the config variables
	// Rest Assured about the URL, Port
	private static Properties prop = ConfigFileReader.ReadProperties();
	private static final String BASE_URL = prop.getProperty("apiURI");
	static Logger logger = Logger.getLogger(EmployeeServiceHelper.class.getName());

	public EmployeeServiceHelper() {
		RestAssured.baseURI = BASE_URL;
		RestAssured.useRelaxedHTTPSValidation();
	}

	public int getAllEmployee() {
		Response response = RestAssured.get(EndPoints.GET_ALL_EMPLOYEE);
		return response.getStatusCode();
	}

	public String createEmployee(String JsonRecordstr) {
		logger.info("# service called to create an employee");
		Response response = RestAssured.given().body(JsonRecordstr).post(EndPoints.CREATE_EMPLOYEE);
		String str = response.getBody().asString();
		assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		return str;
	}

	public JsonPath getSingleEmployee(int id) {
		logger.info("# service called to get a single employee");
		Response response = RestAssured.get(EndPoints.GET_SINGLE_EMPLOYEE + id);
		logger.info("# response status code is: " + response.getStatusCode());
		assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		JsonPath jsonPathEvaluator = response.jsonPath();
		return jsonPathEvaluator;
	}

	public String UpdateEmployee(String JsonRecordstr, int id) {
		logger.info("# service called to update");
		Response response = RestAssured.given().body(JsonRecordstr).put(EndPoints.UPDATE_EMPLOYEE + id);
		String str = response.getBody().asString();
		assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		return str;
	}

	public String DeleteEmployee(int id) {
		logger.info("# service called for delete");
		Response response = RestAssured.delete(EndPoints.DELETE_EMPLOYEE + id);

		String str = response.getBody().asString();
		assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		return str;

	}

}
