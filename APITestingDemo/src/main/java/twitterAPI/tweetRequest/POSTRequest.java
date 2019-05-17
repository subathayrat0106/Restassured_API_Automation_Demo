package twitterAPI.tweetRequest;
import io.restassured.response.Response;

import twitterAPI.BaseRequest;

public class POSTRequest extends BaseRequest{

	public static Response postATweet(String tweetContent) {
		String parametersName = "status";
		Response respon = authResponse()
					.queryParam(parametersName, tweetContent).
				when().
					post(Resources.postATweetResource()).
				then()
					.extract().response();
		return respon;
	}
	
	public static Response deleteATweet(String idNumber) {
		String parametersName = "id";
		Response respon = authResponse().		
					pathParam(parametersName, idNumber).
				when().
					post(Resources.deleteATweetResource(parametersName)).
				then().
					extract().response();
	
		return respon;
	}
	
	public static Response retweetATweet(String idNumber) {
		String parametersName = "id";
		Response respon = authResponse().
					pathParam(parametersName, idNumber).
				when().
					post(Resources.retweetResource(parametersName)).
				then().
					extract().response();
	
		return respon;
	}
	
	public static Response unRetweetATweet(String idNumber) {
		String parametersName = "id";
		Response respon = authResponse().
					pathParam(parametersName, idNumber).
				when().
					post(Resources.unRetweetResource(parametersName)).
				then().
					extract().response();
	
		return respon;
	}
	
	public static Response likeATweet(String idNumber) {
		String parametersName = "id";
		Response respon = authResponse().
					param(parametersName, idNumber).
				when().
					post(Resources.likATweetResource()).
				then().
					extract().response();
	
		return respon;
	}
	
	public static Response unlikeATweet(String idNumber) {
		String parametersName = "id";
		Response respon = authResponse().
					param(parametersName, idNumber).
				when().
					post(Resources.unlikATweetResource()).
				then().
					extract().response();
	
		return respon;
	}
}
