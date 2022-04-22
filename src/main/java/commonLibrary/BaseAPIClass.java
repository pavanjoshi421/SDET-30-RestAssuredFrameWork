package commonLibrary;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass 
{
	public JavaLibrary jlib= new JavaLibrary();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	public DataBaseLibrary dLib= new DataBaseLibrary();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		// establish the db conncetion
		dLib.connectToDB();
		System.out.println("======db conncetion is sucessful");
		
		// set the base uri and port
		baseURI="http://localhost";
		port=8084;
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDb();
	}

}
