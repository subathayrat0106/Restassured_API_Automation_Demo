package apiproject;

import io.restassured.specification.RequestSpecification;
import utilities.JSONPath;
import utilities.PropertiesManager;

import static io.restassured.RestAssured.given;

import apiproject.admin_route.AdminRequest;
import io.restassured.response.Response;

public class BaseRequest {
	
	public static RequestSpecification getTokenAndLogin() {
		PropertiesManager prop = new PropertiesManager("src/main/resources/config.properties");
		String email =prop.readProperty("email");
		String password = prop.readProperty("password");
		//System.out.println(email +" "+ password);
		
		Response response = AdminRequest.loginRequest(email, password);
		
		String token = JSONPath.covertToJSON(response).get("token").toString();
		//System.out.println(token);
		
		RequestSpecification request = given().header("Authorization", "Brear " + token);
		
		return request;
	}

}
