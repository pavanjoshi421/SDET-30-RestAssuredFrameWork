package practice.CRUDOperationWithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTheProject 
{
	@Test
	public void deleteTheProjectTest()
	{
		// step-01: create the prerequsites
		//Step-02: perform the action
		
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_811");
		
		// step-3 validation
		
		response.then().log().all();
		
		int actStatus = response.getStatusCode();
		Assert.assertEquals(actStatus, 204);
		
		//dummy code
		// step-3 validation
		
				response.then().log().all();
				
				int actStatus1 = response.getStatusCode();
				Assert.assertEquals(actStatus, 204);
		
	}

}
