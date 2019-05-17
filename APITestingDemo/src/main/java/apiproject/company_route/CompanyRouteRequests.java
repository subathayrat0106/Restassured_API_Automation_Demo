package apiproject.company_route;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CompanyRouteRequests {

		public static Response getAllCompanyInfoRequest() {
			Response res = given().
							when().
								get(Resources.get_and_postCompanyResource()).
							then().
							 assertThat().statusCode(200).extract().response();
				return res;
						   
		}
		
		public static Response createOneCompanyRequest(String body) {
			Response res = given().
					            contentType(ContentType.JSON).
								body(body).
							when().
								post(Resources.get_and_postCompanyResource()).
							then().
								assertThat().statusCode(201).extract().response();
				return res;
		}
		
		public static Response getOneCompanyInfoRequest(String companyId) {
			Response res = given().
							when().
								get(Resources.getOneCompanyResource(companyId)).
							then().
								extract().response();
				return res;
		}
		
		public static Response updateOneCompanyRequest(String companyId,String body) {
			Response res = given().
					   			contentType(ContentType.JSON).
								body(body).
							when().
								put(Resources.updateOneCompanyResource(companyId)).
							then().
								assertThat().statusCode(200).extract().response();
			System.out.println(companyId);
				return res;
		}	
		
		public static Response deleteOneCompanyRequest(String companyId) {
			Response res = given().
							when().
								delete(Resources.deleteOneCompanyResource(companyId)).
							then().
							 assertThat().statusCode(200).extract().response();
				return res;
		}
		
}
