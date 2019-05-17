package apiproject_testcase;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiproject.user_and_comment_route.UserAndCommentRequests;
import io.restassured.response.Response;
import utilities.JSONPath;

public class UserAndCommentRouteTest extends BaseTest{
	
	private String user_id = "UserId";
	private String comment_id="CommentId";
	@Test(enabled = true,
			priority = 1)
	public void createAUser() {

		Response response = UserAndCommentRequests.postAUserRequest(getAfirstName(), getALastName(), 
				getAEmail(), getAJobType(), getAAddress(), 
				getACity(), getAState(), getAZipCode());
		String id = JSONPath.covertToJSON(response).get("createdUser._id").toString();
		prop.setProperty(user_id, id);	
		String message = JSONPath.covertToJSON(response).get("message").toString();
		Assert.assertEquals(message, "Created user successfully");
	}
	
	@Test(enabled = true,
			priority = 2)
	public void getAllUser() {
		Response response = UserAndCommentRequests.getAllUserInfoRequest();
		int count =  JSONPath.covertToJSON(response).get("count");
		System.out.println(count);
		List<Integer> numUser = JSONPath.covertToJSON(response).getList("user._id");
		System.out.println(numUser);
		Assert.assertEquals(count, numUser.size());
	}
	
	@Test (enabled = true,
			priority = 3)
	public void updateAUser() {
		String userId = prop.readProperty(user_id);
		Response response = UserAndCommentRequests.updateAUserInfoRequest(userId,getAfirstName(), getALastName(), 
				getAEmail(), getAJobType(), getAAddress(), 
				getACity(), getAState(), getAZipCode());
		String message = JSONPath.covertToJSON(response).get("message").toString();
		Assert.assertEquals(message, "User updated");
	}
	
	@Test(enabled = true,
			priority = 4)
	public void postAcommentToAUser() {
		String userId = prop.readProperty(user_id);
		Response response = UserAndCommentRequests.postACommentOfAUserRequest(userId, getAtitle(), getACotent());
		String commentId =JSONPath.covertToJSON(response).get("_id").toString();
		prop.setProperty(comment_id,commentId);	
		String message = JSONPath.covertToJSON(response).get("message").toString();
		Assert.assertEquals(message, "comment created successfully"); 
	}
	
	@Test(enabled = true,
			priority = 5)
	public void updateACommentToAUser() {
		String userId = prop.readProperty(user_id);
		String commentId = prop.readProperty(comment_id);
		Response response = UserAndCommentRequests.updateACommentOfAUserRequest(userId, commentId,getAtitle(),getACotent());
		String message = JSONPath.covertToJSON(response).get("message").toString();
		Assert.assertEquals(message, "Comment updated"); 
	}
	
	@Test(enabled = true,
			priority = 6)
	public void deleteAcommentToUser() {
		String userId = prop.readProperty(user_id);
		String commentId = prop.readProperty(comment_id)
;		Response response = UserAndCommentRequests.deleteAPostOfAUserRequest(userId, commentId);
		String message = JSONPath.covertToJSON(response).get("message").toString();
		Assert.assertEquals(message, "comment deleted"); 
	}
	
	@Test(enabled = true,
			priority = 7)
	public void deleteAUser() {
		String userId = prop.readProperty(user_id);	
     	Response response = UserAndCommentRequests.deleteAUserInfoRequest(userId);
		String message = JSONPath.covertToJSON(response).get("message").toString();
		Assert.assertEquals(message, "user deleted"); 
	}
	
	

}
