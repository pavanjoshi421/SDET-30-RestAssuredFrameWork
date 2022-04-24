package practice.CRUDOperationWithOutBDD;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest
{
	@Test
	public void getSingleProject()
	{
            // Step01: create the prerequistes
		
		// step-2: perform the action
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_811");
		
		// step-3: validate the response
		
		resp.then().log().all();
		System.out.println("swami");
		
		int actStatus = resp.getStatusCode();
		
		Assert.assertEquals(actStatus, 200);
	}

}
