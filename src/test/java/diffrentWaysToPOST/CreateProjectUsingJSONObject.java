package diffrentWaysToPOST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONObject 
{
	@Test
	public void createProject()
	{
		baseURI="http://localhost";
		port=8084;
		JavaLibrary jLib= new JavaLibrary();
		
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Kohli");
		jObj.put("projectName", "TataIPL2021"+jLib.getRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 11);
		
		given().body(jObj)
		.contentType(ContentType.JSON)
		
		.when().post("/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
	}

}
