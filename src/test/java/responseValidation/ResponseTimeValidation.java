package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidation 
{
	@Test
	public void responseTime()
	{
		
		// create the pre-reqisites
		baseURI="http://localhost";
		port=8084;
		
		Response resp = when().get("/projects");
		resp.then().assertThat().time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
		.log().all();
		long time = resp.time();
		System.out.println(time);
		
	}

}
