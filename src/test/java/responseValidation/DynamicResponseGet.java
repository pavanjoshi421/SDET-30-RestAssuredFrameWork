package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseGet 
{
	@Test
	public void dynamicResponse()
	{
	    
		// create the preqsites
		baseURI="http://localhost";
		port=8084;
		String pid="TY_PROJ_809";
		boolean flag=false;
		
		Response resp = when().get("/projects");
		List<String> pIDs = resp.jsonPath().get("projectId");
		for (String projectId : pIDs) 
		{
			if(projectId.equalsIgnoreCase(pid))
			{
				flag=true;
			}
			
		}
		Assert.assertTrue(flag);
		resp.then().log().all();
		
	}


}
