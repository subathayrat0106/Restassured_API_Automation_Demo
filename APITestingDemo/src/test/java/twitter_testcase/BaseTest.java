package twitter_testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import utilities.PropertiesManager;

public class BaseTest {
	
	protected PropertiesManager prop;
	
	@BeforeClass
	public void setUp() {
		prop = new PropertiesManager("src/main/resources/config.properties");
	}

	@BeforeMethod
	public void baseUrl() {
		RestAssured.baseURI = prop.readProperty("TwitterHost");
	}
}
