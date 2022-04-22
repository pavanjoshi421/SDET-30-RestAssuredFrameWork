package diffrentWaysToPOST;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class CreateprojectusingHashMap 
{
	@Test
	public void createProject()
	{
		JavaLibrary jLib= new JavaLibrary();
		baseURI="http://localhost";
		port=8084;
		HashMap map= new HashMap();
		// create the 
	     map.put("createdBy", "David");
	     map.put("projectName", "HDFC "+jLib.getRandomNumber());
	     map.put("status", "Completed");
	     map.put("teamSize", 10);
	     
	     given().body(map)
	     .contentType(ContentType.JSON)
	     .when().post("/addProject")
	     .then().assertThat().statusCode(201)
	     .log().all();
		
	}

}
