package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2_0 
{
	@Test
	public void oauthAuthentication()
	{
		// create the request to genrate the acess token
		
		Response resp = given().
		 formParam("client_id", "SDET-30-RestAssuredCoops")
		.formParam("client_secret", "7d74fd8713775d09183759a130db742c")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://vivek.com")
		.formParam("code", "authorization_code")
		
		.when().post("http://coop.apps.symfonycasts.com/token");
		
		// capture the acess token from the response of the above request
          String token = resp.jsonPath().get("access_token");
          System.out.println(token);
          
          
          // create the another request and use the token to acess the API
          
          given().auth().oauth2(token)
          .pathParam("USER_ID", 3110)
          
          .when()
          .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
          
          .then().log()
          .all();
	}

}
