package DataDrivenTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployees {
	
	@Test(dataProvider="empDataProvider")
	void addNewEmployees(String name, String age, String sal) {
		// sepecify base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		// send data along with the post request
		requestParams.put("name", name);
		requestParams.put("salary", age);
		requestParams.put("age", sal);

		// add header stating the request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// add the json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		// post request
		Response response = httpRequest.request(Method.POST, "/create");

		// capture response body to perform validations
		String responseBody = response.getBody().asString();
		System.out.println("eResponse body is: "+ responseBody);
		System.out.println("responseBody is: " + responseBody);
		Assert.assertEquals(responseBody.contains(name), true);
		Assert.assertEquals(responseBody.contains(age), true);
		Assert.assertEquals(responseBody.contains(sal), true);

		// validate status code
		int statusCode = response.getStatusCode();
		System.out.println("status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// validate statusLine
		String statusLine = response.getStatusLine();
		System.out.println("statusLine is : " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@DataProvider(name="empDataProvider")
	String[][] getEmpData(){
		String empdata[][]= {{"harkey", "948594", "40"}, {"hi", "98493", "32"}, {"ksdfjksd", "34343", "34"}};
		return(empdata);
	}
}
