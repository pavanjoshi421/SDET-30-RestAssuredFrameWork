package requestChainig;

import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import projectLibrary.ProjectLibraray;

import static io.restassured.RestAssured.*;

public class CreateAndDeleteTheProject
{
	@Test
	public void createTheProject()
	{
		JavaLibrary jLib= new JavaLibrary();
		
		ProjectLibraray pLib= new ProjectLibraray(DEFAULT_SESSION_ID_VALUE, DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH, DEFAULT_PORT);
		baseURI="http://localhost";
		port=8084;
		// create the projcect
	}

}
