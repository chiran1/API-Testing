package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Request_Authorization {
	
	@Test
	void Authorization() {
		//sepecify base URI
				RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
				
				
				//basic authentication
				PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
				authscheme.setUserName("ToolsQA");
				authscheme.setPassword("TestPassword");
				
				RestAssured.authentication = authscheme;
				
				//request object
				RequestSpecification httpRequest = RestAssured.given();
				
				//response object
				Response response= httpRequest.request(Method.GET, "/");
				//print response in the console
				
				String responseBody = response.getBody().asString();
				System.out.println("responseBody is: "+responseBody);
				
				//validate status code
				int statusCode = response.getStatusCode();
				System.out.println("status code is : "+statusCode);
				Assert.assertEquals(statusCode, 200);
				
			
	}

}
