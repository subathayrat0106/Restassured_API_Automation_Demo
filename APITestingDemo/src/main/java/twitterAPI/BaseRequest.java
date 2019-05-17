package twitterAPI;

import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	protected static final String CONSUMER_API_KEYS = "AlJtfAh2nXUhKymmoxgqplv07";
	protected static final String CONSUMER_API_SECRT_KEY = "7LUpm9acX4FDIVdR7NJCdRqTgVjAsX5XvS9xGwTa6Cq6IEorRd";
	protected static final String ACCESS_TOKEN = "1123402538055634944-jloFPmZmathRIF1QufvFMnOOtboTcO";
	protected static final String ACCESS_TOKEN_SECRT = "MhPFg8SwNhprOGWZ2my6BdpyRMKz64sFUlgJFpk5h8g2b";
	
	protected static RequestSpecification authResponse() {
	RequestSpecification response = given().
				auth().
					oauth(CONSUMER_API_KEYS, CONSUMER_API_SECRT_KEY,ACCESS_TOKEN, ACCESS_TOKEN_SECRT);
					return response;
	}
}
