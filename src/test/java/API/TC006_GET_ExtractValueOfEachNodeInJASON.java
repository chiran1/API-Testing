package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_ExtractValueOfEachNodeInJASON {

	@Test
	void getWeatherDetailsVerify() {
		// sepecify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// request object

		RequestSpecification httpRequest = RestAssured.given();

		// response object
		Response response = httpRequest.request(Method.GET, "/Goa");

		// extract the each node and values, then use JSON path class

		JsonPath jsonPath = response.jsonPath();
		System.out.println(jsonPath.get("City"));
		System.out.println(jsonPath.get("Temperature"));
		System.out.println(jsonPath.get("Humidity"));
		System.out.println(jsonPath.get("WeatherDescription"));
		System.out.println(jsonPath.get("WindSpeed"));
		System.out.println(jsonPath.get("WindDirectionDegree"));

		// verify all the nodes in the response body.

		Assert.assertEquals(jsonPath.get("City"), "Goa");

	}

}
