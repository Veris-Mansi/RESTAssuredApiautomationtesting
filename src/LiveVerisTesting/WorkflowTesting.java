package LiveVerisTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;;

public class WorkflowTesting {

	@Test
	public void AddWorkflow()
	{
		String posting="{\r\n" + 
				"    \"title\": \"Inviteds\",\r\n" + 
				"    \"status\":2,\r\n" + 
				"    \"form_type\":\"Inviteds\",\r\n" + 
				"    \"screens\": [\r\n" + 
				"       \r\n" + 
				"    ]\r\n" + 
				"}";
		RestAssured.baseURI="https://live.veris.in/";
		given().
		
		headers("Authorization","token a7d41ce2cb375a9dc17111f1f67589127ba49726").
		headers("Content-Type","application/json").
		body(posting).
		when().redirects().follow(true).
		post("api/v2/organization/1728/forms").
		then().assertThat().statusCode(201).and().contentType(ContentType.JSON);
		
	}
}
