package practice.CRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateTheProjectTest 
{
	@Test
	public void updateProjecTest()
	{
		baseURI="http://localhost";
		port=8084;
		// create the pre-reqisites
	   JSONObject jObj= new JSONObject();
	   jObj.put("createdBy", "Kohli");
	   jObj.put("projectName", "TataIPL2021");
	   jObj.put("status", "Completed");
	   jObj.put("teamSize", 12);
		// perform the action
		given().body(jObj)
		.contentType(ContentType.JSON)
		
		.when().put("projects/TY_PROJ_1203")
		
		// validate
		
		.then().assertThat().contentType(ContentType.JSON)
		.statusCode(200).log().all();
		
		
		
		
	}

}
