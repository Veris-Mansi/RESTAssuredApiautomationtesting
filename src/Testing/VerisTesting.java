package Testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;;

public class VerisTesting {

	@Test
	public void TestingGET()
	{
		RestAssured.baseURI="https://live.veris.in";
		given().
		headers("Authorization", "token 8dcf8f2c7057c9594d2b5b3587ebb2825bb3900a");
		when().
		get("/api/v2/profile/").
		then().assertThat().statusCode(401).and().contentType(ContentType.JSON);
		
	}
}
