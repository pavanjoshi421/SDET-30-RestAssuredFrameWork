package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken 
{
	@Test
	public void createRepo()
	{
		baseURI="https://api.github.com";
		JSONObject jObj=new JSONObject();
		jObj.put("name", "SDET-30-RestAssured");
		
		given().
		auth().oauth2("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")
		.body(jObj)
		
		.contentType(ContentType.JSON)
		
		.when().post("/user/repos")
		.then().assertThat().statusCode(201)
		.log().all();
	}

}
