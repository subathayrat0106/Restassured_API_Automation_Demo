package apiproject_testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiproject.admin_route.AdminRequest;
import io.restassured.response.Response;
import utilities.JSONPath;

public class AdminRouteTest extends BaseTest{

		private String key_email ="email";
		private String key_password = "password";
	
		
		@Test(enabled = false)
		public void signUpAsAdim() {
			String email = getAEmail();
			String password = getAPassword();
			prop.setProperty(key_email, email);
			prop.setProperty(key_password, password);
			Response response = AdminRequest.signUpRequest(email, password);
					
			String msg = JSONPath.covertToJSON(response).get("message").toString();
			Assert.assertEquals(msg, "Admin created");			
		}
		
		@Test(enabled = true)
		public void loginAsAdmin() {
			String email = prop.readProperty(key_email);
			String password = prop.readProperty(key_password);
			Response response = AdminRequest.loginRequest(email, password);
			String msg = JSONPath.covertToJSON(response).get("message").toString();
			Assert.assertEquals(msg, "Auth successful");		
		}
}
