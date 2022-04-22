package diffrentWaysToPOST;

import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibrary.ProjectLibraray;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO
{
	@Test
	public void createProject()
	{
		JavaLibrary jLib= new JavaLibrary();
	   ProjectLibraray pLib= new ProjectLibraray("Angelo", "Ares"+jLib.getRandomNumber(), "Completed", 5);
	   
	   
	   baseURI="http://localhost";
	   port=8084;
	   
	   given().body(pLib)
	   .contentType(ContentType.JSON)
	   .when().post("/addProject")
	   .then().assertThat().statusCode(201)
	   .log().all();
	   
	}

}
