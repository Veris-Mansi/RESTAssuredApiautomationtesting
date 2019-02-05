package LoginRegisterAPITesting;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.payloadData;
import files.resource;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class LoginTesting {

	Properties prop= new Properties();
	@BeforeTest
	public void getData() throws IOException,FileNotFoundException
	{
		FileInputStream fis = new FileInputStream("D:\\Selenium_Projects\\Project\\RestAssuredTesting\\src\\files\\env.properties");
		prop.load(fis);
		prop.get("HOST");
	}
	@Test(priority=1,description="testing with correct login credentials")
	public void correctLoginCredentials() throws InterruptedException
	{
		RestAssured.baseURI=prop.getProperty("HOST");
		given().headers("Content-Type","application/json").body(payloadData.correctLoginPayload()).
		when().post(resource.loginResource()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("message", equalTo("Login succesful"));
		Thread.sleep(5000);
	}
		@Test(priority=2,description="testing with incorrect login credentials ")
		public void incorrectLoginCredentials()
		{
			//RestAssured.baseURI=prop.getProperty(resource.loginResource());
			given().headers("Content-Type","application/json").body(payloadData.incorrectLoginPayload()).
			when().post(resource.loginResource()).
			then().assertThat().statusCode(404).and().contentType(ContentType.JSON).and().body("message", equalTo("No account with this email"));
			
		}
		@Test(priority=3,description="testing with incorrect password")
		public void incorrectLoginpassword()
		{
			//RestAssured.baseURI=prop.getProperty(resource.loginResource());
			given().headers("Content-Type","application/json").body(payloadData.incorrectpasswordLoginPayload()).
			when().post(resource.loginResource()).
			then().assertThat().statusCode(401).and().contentType(ContentType.JSON).and().body("message", equalTo("Unauthorized Access"));
			
		}
		@Test(priority=3,description="testing with empty password ")
		public void emptyLoginEmail()
		{
			//RestAssured.baseURI=prop.getProperty(resource.loginResource());
			given().headers("Content-Type","application/json").body(payloadData.emptyemailLoginPayload()).
			when().post(resource.loginResource()).
			then().assertThat().statusCode(400).and().contentType(ContentType.JSON).and().body("message", equalTo("Bad Request"));
			
		}
		@Test(priority=4,description="testing with empty email")
		public void emptyLoginPassword()
		{
			//RestAssured.baseURI=prop.getProperty(resource.loginResource());
			given().headers("Content-Type","application/json").body(payloadData.emptypasswordLoginPayload()).
			when().post(resource.loginResource()).
			then().assertThat().statusCode(400).and().contentType(ContentType.JSON).and().body("message", equalTo("Bad Request"));
			
		}
		
}
