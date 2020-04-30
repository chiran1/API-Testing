package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request_validatingJSON_Response {
	
	@Test
	void getWeatherDetailsVerify() {
		//sepecify base URI
				RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
				
				//request object
				
				RequestSpecification httpRequest = RestAssured.given();
				
				//response object
				Response response= httpRequest.request(Method.GET, "/Goa");
				
				//print response in the console
				String responseBody = response.getBody().asString();
				System.out.println("responseBody is: "+responseBody);
				
				//verify if the response body has certain value
				Assert.assertEquals(responseBody.contains("Goa"), true);
				
				
	}
	

}
