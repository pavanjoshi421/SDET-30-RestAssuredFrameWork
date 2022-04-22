package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationGet 
{
	@Test
	public void staicResponseGet()
	{
		String expData="TY_PROJ_002";
		baseURI="http://localhost";
		port=8084;
		
		// create the pre-requisites
		
		// perform the action
		
	     Response resp = when().get("/projects");
	     String actId = resp.jsonPath().get("[0].projectId");
	     Assert.assertEquals(actId,expData);
	     
	     System.out.println("data verified");
	     
	     resp.then().log().all();
	     
	     
	}
	

}
