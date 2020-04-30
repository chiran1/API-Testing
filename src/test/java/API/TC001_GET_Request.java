package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getWeatherDetails() {
		
		//sepecify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//request object
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		Response response= httpRequest.request(Method.GET, "/Goa");
		
		//print response in the console
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is: "+responseBody);
		
		//validate status code
		int statusCode = response.getStatusCode();
		System.out.println("status code is : "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//validate statusLine
		String statusLine = response.getStatusLine();
		System.out.println("statusLine is : "+statusLine);
		Assert.assertEquals(statusCode, "HTTP/1.1 200 OK");
		
	}

}
