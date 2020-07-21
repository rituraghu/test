import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyTheStatusCode {
	
	@Test
	 public void GetWeatherDetails()
	 {
	 RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");
	 
	
	 int statusCode = response.getStatusCode();
	 
	 // Assert that correct status code is returned.
	 Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	 }

}
