package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2_0_Second 
{
	@Test
	public void oAuth2_0Authentication()
	{
	   // create the request 
		
		Response resp = given().
		formParam("client_id", "QSidersApp")
		.formParam("client_secret", "97be0bd6eaeda087625d7c7d7cf6bfdb")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://vivek.com")
		.formParam("code", "authorization_code only")
		
		.when().post("http://coop.apps.symfonycasts.com/token");
		
		String token = resp.jsonPath().get("ccess_token");
		System.out.println(token);
		
		given().auth().oauth2(token)
		.pathParam("USER_ID", 3110)
		.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		
		.then().log().all();
		
		
	}

}
