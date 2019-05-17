package apiproject_testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import utilities.PropertiesManager;

public class BaseTest {
protected PropertiesManager prop;
protected Faker faker;
	
	@BeforeClass
	public void setUp() {
		prop = new PropertiesManager("src/main/resources/config.properties");
		faker = new Faker();
	}

	@BeforeMethod
	public void baseUrl() {
		RestAssured.baseURI = prop.readProperty("APIProjectHost");
	}
	
	protected String getCompanyName() {
		String name = faker.company().name();
		return name;
	}
	
	protected String getCompanySuffix() {
		String suffix = faker.company().suffix();
		return suffix;
	}
	
	protected String getCompanyUrl() {
		String url = faker.internet().url();
		return url;
	}
	
	protected String getCompanyAccountName() {
		String accountName = faker.business().creditCardType();
		return accountName;
	}
	
	protected String getCompanyAccountNumber() {
		String accountNum = faker.number().digits(15);
		return accountNum;
	}
	
	protected String getAEmail() {
		String email = faker.internet().emailAddress();
		return email;
	}
	
	protected String getAPassword() {
		String password = faker.internet().password();
		return password;
	}
	
	protected String getAfirstName() {
		String firstName = faker.name().firstName();
		return firstName;
	}
	
	protected String getALastName() {
		String lastName = faker.name().lastName();
		return lastName;
	}
	
	protected String getAJobType() {
		String jobType = faker.job().field();
		return jobType;
	}
	
	protected String getAAddress() {
		String address = faker.address().streetAddress();
		return address;
	}
	
	protected String getACity() {
		String city = faker.address().city();
		return city;
	}
	
	protected String getAState() {
		String state = faker.address().state();
		return state;
	}
	
	protected String getAZipCode() {
		String zipCode = faker.number().digits(6);
		return zipCode;
	}
	
	protected String getAtitle() {
		String title = faker.lorem().characters(true);
		return title;
	}
	
	protected String getACotent() {
		String content = faker.lorem().sentence();
		return content;
	}
}

