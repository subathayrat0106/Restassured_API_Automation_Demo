package apiproject.user_and_comment_route;

import apiproject.BaseRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class UserAndCommentRequests extends BaseRequest{
	
	public static Response getAllUserInfoRequest() {
		Response res = getTokenAndLogin().
						when().
							get(Resources.getAllUsersResource()).
						then().
						 assertThat().statusCode(200).extract().response();
			return res;
					   
	}
	
	public static Response postAUserRequest(String firstName, String lastName, String email,String jobType
			,String street,String city, String state, String zipCode) {
		Response res = getTokenAndLogin().
					contentType(ContentType.JSON).
					body(Payload.userPayload(firstName, lastName, email, jobType, street, city, state, zipCode)).
				when().
					post(Resources.getAllUsersResource()).
				then().
				 assertThat().extract().response();
		return res;
	}
	
	public static Response getAUserInfoRequest(String userId) {
		Response res = getTokenAndLogin().
						when().
							get(Resources.getAUserInfo(userId)).
						then().
						 assertThat().statusCode(200).extract().response();
			return res;
					   
	}
	
	public static Response updateAUserInfoRequest(String userId,String firstName, String lastName, String email,String jobType
			,String street,String city, String state, String zipCode) {
		Response res = getTokenAndLogin().
				contentType(ContentType.JSON).
				body(Payload.userPayload(firstName, lastName, email, jobType, street, city, state, zipCode)).
			when().
				put(Resources.updateAllUserInfo(userId)).
			then().
			 assertThat().extract().response();
		return res;
	}
	
	public static Response deleteAUserInfoRequest(String userId) {
		Response res = getTokenAndLogin().
				when().
					delete(Resources.deleteOneUser(userId)).
				then().
				 assertThat().statusCode(200).extract().response();
		return res;
	}
	
	public static Response postACommentOfAUserRequest(String userId,String title, String content) {
		Response res = getTokenAndLogin().
					contentType(ContentType.JSON).
					body(Payload.commentPayload(title, content)).
				when().
					post(Resources.postACommentToAUser(userId)).
				then().
				 assertThat().statusCode(201).extract().response();
		return res;
	}

	public static Response getAPostInfoRequest(String userId, String commentId) {
		Response res = getTokenAndLogin().
						when().
							get(Resources.getACommentOfAUser(userId, commentId)).
						then().
						 assertThat().statusCode(200).extract().response();
			return res;
					   
	}
	
	public static Response updateACommentOfAUserRequest(String userId,String commentId,String title, String content) {
		Response res = getTokenAndLogin().
				contentType(ContentType.JSON).
					body(Payload.commentPayload(title, content)).
				when().
					put(Resources.updateAComment(userId, commentId)).
				then().
				 assertThat().extract().response();
		return res;
	}
	
	public static Response deleteAPostOfAUserRequest(String userId,String commentId) {
		Response res = getTokenAndLogin().
				when().
					delete(Resources.deleteAComment(userId, commentId)).
				then().
				 assertThat().statusCode(200).extract().response();
		return res;
	}
}
