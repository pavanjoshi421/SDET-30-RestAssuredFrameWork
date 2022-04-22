package commonLibrary;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

/**
 * This class contains generic methods of restassured
 * @author VIVEK
 *
 */

public class RestAssuredLibrary 
{
	/** 
	 * This method will return the json path
	 * @param response
	 * @param jsonPath
	 * @return
	 */
	public String getJsonPath(Response response,String jsonPath)
	{
		String value = response.jsonPath().get(jsonPath);
		return value;
		
	}

}
