package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import projectLibrary.ProjectLibraray;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationPost 
{
	@Test
	public void staticResponsePost()
	{
		
		JavaLibrary jLib= new JavaLibrary();
		ProjectLibraray pLib= new ProjectLibraray("Nicola", "posiedon"+jLib.getRandomNumber(), "Completed", 6);
	     // create the pre-requisites
		
		baseURI="http://localhost";
		port=8084;
		
		 Response respo = given().body(pLib)
		.contentType(ContentType.JSON)
		
		
		// perform the action
		.when().post("/addProject");
		
	String actData = respo.jsonPath().get("projectName");
		
		Assert.assertTrue(actData.contains("posiedon"));
		
		System.out.println("data verified");	
		
		respo.then().log().all();
		
		
		
		
		
	}

}
