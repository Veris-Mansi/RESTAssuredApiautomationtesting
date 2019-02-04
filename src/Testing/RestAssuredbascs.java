package Testing;

import files.resource;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.xml.fastinfoset.sax.Properties;
public class RestAssuredbascs {

	java.util.Properties prop = new java.util.Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis= new FileInputStream("D:\\Selenium_Projects\\Project\\RestAssuredTesting\\src\\files\\env.properties");
		prop.load(fis);
		prop.get("HOST");
	}
	@Test
	public void test1()
	{
		RestAssured.baseURI=prop.getProperty("HOST");
		
		given().	
		param("location","-33.8670522,151.1957362").
		param("radius","500").
		param("key", prop.getProperty("KEY")).
		when().	//request type and resource to hit
		get(resource.placeGetData()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("results[0].name",equalTo("Sydney")).and().body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
		header("server", "scaffolding on HTTPServer2");
		//System.out.println("passed");
			
		
			
	}
}
