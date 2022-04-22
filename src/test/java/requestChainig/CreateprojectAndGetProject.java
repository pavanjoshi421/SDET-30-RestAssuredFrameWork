package requestChainig;

import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.ProjectLibraray;

import static io.restassured.RestAssured.*;

public class CreateprojectAndGetProject 
{
	@Test
	public void createTheProject()
	{
		JavaLibrary jLib= new JavaLibrary();
		
		baseURI="http://localhost";
		port=8084;
		// create the project using pojo 
		ProjectLibraray pLib= new ProjectLibraray("HAL", "helicopter "+jLib.getRandomNumber(), "On Going", 10);
		
		Response resp = given().body(pLib)
		.contentType(ContentType.JSON)
		
		.when().post("/addProject");
		
		// capture the project id
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		// create the get request and pass the pro id as path parameter
		
		given().pathParam("pid", proId)
		.when().get("/projects/{pid}")
		.then().assertThat().statusCode(200)
		.log().all();
	
	}

}
