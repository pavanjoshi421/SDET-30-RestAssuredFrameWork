package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter 
{
	@Test
	public void queryParameter()
	{
		baseURI="https://reqres.in";
		// create the pre-reqisites
		given().queryParam("page", 2)
		// perform the action
		.when().get("/api/users")
		// validation
		.then().log().all();
		
	}

}
