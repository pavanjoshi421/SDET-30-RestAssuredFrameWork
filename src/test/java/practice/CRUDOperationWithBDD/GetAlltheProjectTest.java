package practice.CRUDOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAlltheProjectTest 
{
	@Test
	public void getAllTheProjectTest()
	{
		baseURI="http://localhost";
		port=8084;
		
		// create the pre-requsites
		
		// perform the action
		
		when().get("projects")
		.then().log().all();
	}

}
