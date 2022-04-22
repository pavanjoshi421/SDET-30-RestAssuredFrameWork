package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter
{
	@Test
	public void pathParameterGetSingleProject()
	{
		
		// create the pre-reqisites
		baseURI="http://localhost";
		port=8084;
		given().pathParam("pid", "TY_PROJ_1610")
		// perform action
		.when().get("/projects/{pid}")
		// validation
		.then().log().all();
	}

}
