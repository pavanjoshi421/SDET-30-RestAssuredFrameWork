package practice.CRUDOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProjectTest 
{
	@Test
	public void getSingleProjectTest()
	{
	  baseURI="http://localhost";
	  port=8084;
	  
	  when()
	  .get("projects/TY_PROJ_812")
	  .then().assertThat().contentType(ContentType.JSON)
	  .statusCode(200).log().all();
	}

}
