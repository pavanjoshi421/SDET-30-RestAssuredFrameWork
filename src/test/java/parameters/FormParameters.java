package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameters 
{
	@Test
	public void formParameter()
	{
		baseURI="http://localhost";
		port=8084;
	    // create the pre-reqisites
		given().formParam("createdBy", "isaka")
		.formParam("projectName", "cronus")
		.formParam("status", "Completed")
		.formParam("teamSize", 10)
		.contentType(ContentType.JSON)
		// perform the action
		.when().post("/addProject")
		// validation
		.then().log().all();
	}

}
