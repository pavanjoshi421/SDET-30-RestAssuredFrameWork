package practice.CRUDOperationWithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest 
{
	@Test
	public void getAllProjectsTest()
	{
		// step-01 create the pre-requisties
		// step-01 perform the action
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		// step-3 validation
		
		resp.then().log().all();
		
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(actStatus, 200);
	}

}
