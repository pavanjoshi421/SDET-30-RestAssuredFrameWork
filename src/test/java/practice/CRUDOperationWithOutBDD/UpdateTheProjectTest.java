package practice.CRUDOperationWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateTheProjectTest 
{
	@Test
	public void updateTheProjectTest()
	{
		// Step-01: create the Prerequsites
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Mitu");
		jObj.put("projectName", "Dell_163");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 49);
		
		RequestSpecification request = RestAssured.given();
		request.body(jObj);
		request.contentType(ContentType.JSON);
		
		// step-2 : prform the action
		Response response = request.put("http://localhost:8084/projects/TY_PROJ_811");
		
		// step-3: validating the response
		
	System.out.println(response.statusCode());
	System.out.println(response.prettyPrint());
	System.out.println(response.prettyPeek());
	System.out.println(response.asString());
	}

}
