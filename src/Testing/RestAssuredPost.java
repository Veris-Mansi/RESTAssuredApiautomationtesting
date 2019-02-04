package Testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.when;

public class RestAssuredPost {
//parameters
	//path parameter,query,header
	//data is passed as a part of body only
	@Test
	public void APITesting()
	{
		String p ="{\r\n" + 
				"    \"name\": \"mmorpheus\",\r\n" + 
				"    \"job\": \"lleader\"\r\n" + 
				"}";
		RestAssured.baseURI="https://reqres.in/";
		given().
		//queryParam("key","AIzaSyCYD6BIkRhzwubWZtT5jSfX_A_NuQKfL6A").
		body(p);
		when().
		post("/api/users").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
		//body("id",equalTo(operand))
	}
}
