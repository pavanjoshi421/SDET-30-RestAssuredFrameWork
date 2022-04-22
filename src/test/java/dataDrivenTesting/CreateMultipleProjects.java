package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import projectLibrary.ProjectLibraray;

public class CreateMultipleProjects 
{
	@Test(dataProvider = "getData")
	public void createProject(String createdBy,String projectName, String status, int teamSize)
	{
		JavaLibrary jLib= new JavaLibrary();
		ProjectLibraray pLib= new ProjectLibraray(createdBy, projectName+jLib.getRandomNumber(), status, teamSize);
		
		// create the pre-reqsites
		
		baseURI="http://localhost";
		port=8084;
		given().body(pLib)
		.contentType(ContentType.JSON)
		
		// perform the action
		
		.when().post("/addProject")
		
		// validation
		.then().log().all();
		
	}
	
	
	@DataProvider(name = "getData")
	public Object[][] data()
	{
		Object[][] data= new Object[2][4];
		
		data[0][0]="dani";
		data[0][1]="AntAres";
		data[0][2]="On Going";
		data[0][3]=10;
		
		data[1][0]="nicola";
		data[1][1]="Ares";
		data[1][2]="completed";
		data[1][3]=10;
		
		return data;
	}

}
