package LoginRegisterAPITesting;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.resource;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.when;

public class GetUsersTesting {

	Properties prop= new Properties();

	@BeforeTest
	public void getDAta() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Selenium_Projects\\Project\\RestAssuredTesting\\src\\files\\env.properties");
		prop.load(fis);
		prop.get("HOST");
	}
	
	@Test(priority=1, description="Get_Users:Correct End point entered")
	public void getUsers()
	{
		RestAssured.baseURI=prop.getProperty("HOST");
		Response res=(Response) given().
				headers("Content-Type","application/json").
				when().get(resource.fetchData()).
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
				extract().response();
		
		String response=res.asString();
		
		System.out.println(response);
		//JsonParser parser = new JSO	
	}
	@Test(priority=2,description="Get_Users:INcorrect End point entered")
	public void getUsersIncorrectUrl()
	{
				given().
				headers("Content-Type","application/json").
				when().get("/getuser").
				then().assertThat().statusCode(404).and().contentType(ContentType.HTML);
	
	}
	
	
}
