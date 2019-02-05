package LoginRegisterAPITesting;

import org.jvnet.staxex.StAxSOAPBody.Payload;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import files.payloadData;
import files.resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
public class RegisterUsers {

	Properties prop= new Properties();
	Response res;
	Response res2;
	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Selenium_Projects\\Project\\RestAssuredTesting\\src\\files\\env.properties");
		prop.load(fis);
		prop.get("HOST");
				
	}
	@Test(priority=1,description ="Registering users with correct credentials")
	public void RegisterUSer() throws InterruptedException
	{
		RestAssured.baseURI="http://127.0.0.1:5000";
		res = given().
		headers("Content-Type","application/json").
		body(payloadData.getPostData()).
		when().post(resource.registerResource()).then().
		assertThat().statusCode(201).contentType(ContentType.JSON).body("message",equalTo("User added succesfully")).
		extract().response();
		
		String response =res.asString();
		JsonPath js=new JsonPath(response);
		String user_id=js.get("data");
		System.out.println("User_Id "+user_id);
		Thread.sleep(10000);
	}
		@Test(priority=2,description="registering users with duplicate credentials")
		public void RegisteredDuplicateUser() throws InterruptedException
		{
			 given().
					headers("Content-Type","application/json").
					body(payloadData.getPostData()).
					when().post(resource.registerResource()).then().
					assertThat().statusCode(409).contentType(ContentType.JSON).body("message",equalTo("Username or Email already exist"));
			 		Thread.sleep(5000);
		}
		
		@Test(priority=3,description="registering users with duplicate username")
		public void RegisteredDuplicateUsername() throws InterruptedException
		{
			 given().
				headers("Content-Type","application/json").
				body(payloadData.getDuplicateUsername()).
				when().post(resource.registerResource()).then().
				assertThat().statusCode(409).contentType(ContentType.JSON).body("message",equalTo("Username or Email already exist"));
			 	Thread.sleep(2000);
		}

		@Test(priority=4,description="registering users with duplicate email")
		public void RegisteredDuplicateEmail() throws InterruptedException
		{
			 given().
				headers("Content-Type","application/json").
				body(payloadData.getDuplicateUsername()).
				when().post(resource.registerResource()).then().
				assertThat().statusCode(409).contentType(ContentType.JSON).body("message",equalTo("Username or Email already exist"));
			 	Thread.sleep(2000);
		}



}
