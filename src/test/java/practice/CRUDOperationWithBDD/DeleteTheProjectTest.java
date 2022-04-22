package practice.CRUDOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteTheProjectTest 
{
	@Test
	public void deleteTheProjectTest()
	{
		baseURI="http://localhost";
		port=8084;
		
		// create the pre=requsites
		
		// perform the action
		
		when().delete("projects/TY_PROJ_812")
		.then().assertThat().statusCode(204)
		.log().all();
	}

}
