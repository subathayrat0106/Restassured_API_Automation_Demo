package twitterAPI.tweetRequest;

import io.restassured.response.Response;
import twitterAPI.BaseRequest;

public class GETRequest extends BaseRequest{

		public static Response getSingleTweet(String idNumber) {
			String parametersName = "id";
			Response respon = authResponse()
					.param(parametersName, idNumber).
				when().
					get(Resources.showAtweetResource()).
				then()
					.extract().response();
		return respon;
		}
}
