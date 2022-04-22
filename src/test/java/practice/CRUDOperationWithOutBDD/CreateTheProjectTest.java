package practice.CRUDOperationWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateTheProjectTest 
{
	@Test
	public void createprojectTest()
	{
		// Step-01 create the prerequisites- request body
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Faf");
		jObj.put("projectName", "Rcb");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 11);
		
		RequestSpecification request = RestAssured.given();
		request.body(jObj);
		request.contentType(ContentType.JSON);
		
		// Step-2 : perform the action
		
		Response response = request.post("http://localhost:8084/addProject");
		
		// Step-3 validate the response
		
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
	}

}
