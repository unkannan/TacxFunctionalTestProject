package APIFrame.helpers;
 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import java.util.Properties;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

//import com.org.test.RestApiAutomation;
import com.org.utility.ConfigFileReader;

import APIFrame.constants.EndPoints;
import APIFrame.model.Employee; 

public class EmployeeServiceHelper {// We need to read the config variables
    // Rest Assured about the URL, Port
    // Make a Get REQUEST on this url and send the data to TestGETPerson
	private static Properties prop = ConfigFileReader.ReadProperties();
    private static final String BASE_URL = prop.getProperty("apiURI");//prop.getInstance( ).getString("base_url");
    static Logger logger = Logger.getLogger(EmployeeServiceHelper.class.getName());
    public EmployeeServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation( );
    }

    public int getAllEmployee() {
        Response response = RestAssured.get(EndPoints.GET_ALL_EMPLOYEE);
        return response.getStatusCode( );
    }


    public Response createEmployee() {

        // Need to make a Post call
        Response response = RestAssured.given( )
                .contentType(ContentType.JSON)
              //  .when( )
               // .body(employee)
                .post(EndPoints.CREATE_EMPLOYEE);
               // .andReturn( );

        assertEquals(response.getStatusCode( ), HttpStatus.SC_CREATED, "Created");


        return response;
    }

	public JsonPath getSingleEmployee(int id) {
		Response response=RestAssured.get(EndPoints.GET_SINGLE_EMPLOYEE+id);
		logger.info("# response status code is: "+response.getStatusCode());
		assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		 JsonPath jsonPathEvaluator = response.jsonPath();
		return jsonPathEvaluator;
	}


}
