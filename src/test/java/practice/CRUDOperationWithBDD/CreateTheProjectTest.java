package practice.CRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateTheProjectTest 
{
	@Test
	public void createTheProjectTest()
	{
		baseURI="http://localhost";
		port=8084;
		// Step:1 create the pre-requsites
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Kohli");
		jObj.put("projectName", "TataIPL2021");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 11);
		
		given().body(jObj)
		.contentType(ContentType.JSON)
		
		// step-2 perform the action
		
		.when().post("addProject")
		
		// step-3 validate the response
		
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}

}
