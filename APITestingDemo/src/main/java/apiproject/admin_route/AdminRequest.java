package apiproject.admin_route;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class AdminRequest {

		public static Response signUpRequest(String email, String password) {
			Response response = given().
									contentType(ContentType.JSON).
									body(Payload.adminPayload(email, password)).
								when().
									post(Resources.signUpResource()).
								then().
									extract().response();
			return response;
		}
		
		public static Response loginRequest(String email, String password) {
			Response response = given().
					                contentType(ContentType.JSON).
									body(Payload.adminPayload(email, password)).
								when().
									post(Resources.loginResource()).
								then().
									extract().response();
			return response;
		}
		
		public static Response deleteAdminRequest(String adminId) {
			Response response = given().
								when().
									delete(Resources.deleteResource(adminId)).
								then().
									extract().response();
			return response;
		}
}
