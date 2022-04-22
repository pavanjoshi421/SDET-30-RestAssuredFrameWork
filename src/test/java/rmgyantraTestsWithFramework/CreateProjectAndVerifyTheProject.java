package rmgyantraTestsWithFramework;

import org.testng.annotations.Test;

import commonLibrary.BaseAPIClass;
import commonLibrary.EndPointsLibraray;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import projectLibrary.ProjectLibraray;

public class CreateProjectAndVerifyTheProject extends BaseAPIClass
{
	@Test
	public void createTheProjectVerifyInDB() throws Throwable
	{
		// create the pre-reqisite
         ProjectLibraray pLib= new ProjectLibraray("Vj","Axis", "Completed"+jlib.getRandomNumber(), 10);
         
         
          Response resp = given().body(pLib)  // perform the action
           .contentType(ContentType.JSON)
           
           .when().post(EndPointsLibraray.CreateProject);
          
          String expData = rLib.getJsonPath(resp, "projectId");
          System.out.println(expData);
		
          // verify the project in API response
          
          given().pathParam("pid", expData)
          .when().get(EndPointsLibraray.GetSingleProject+"/{pid}")
          .then().log().all();
          
          System.out.println("data sucessfully verified");
          
          
          // verify the project in databse
          
          String query="select * from project";
         String data = dLib.executeQueryAndGetData(query, 1, expData);
         System.out.println(data);
         
         System.out.println("data sucessfully verified");
		
		
		
	
	}
	

}
