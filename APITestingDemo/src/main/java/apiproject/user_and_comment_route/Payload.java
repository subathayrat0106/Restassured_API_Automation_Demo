package apiproject.user_and_comment_route;

import org.json.JSONObject;

public class Payload {

	public static String userPayload(String firstName, String lastName, String email,String jobType
			,String street,String city, String state, String zipCode){
		JSONObject userparams = new JSONObject();
		JSONObject addressparam = new JSONObject();
		
		userparams.put("first_name", firstName);
		userparams.put("last_name", lastName);
		userparams.put("email", email);
		userparams.put("job_type", jobType);
		
		addressparam.put("street_address",street);
		addressparam.put("city", city);
		addressparam.put("state", state);
		addressparam.put("zip_code", zipCode);
		
		userparams.put("address", addressparam);
		String jsonBody = userparams.toString();
		return jsonBody;
	}
	
	public static String commentPayload(String title, String content) {
		JSONObject commentparams = new JSONObject();
		commentparams.put("title", content);
		commentparams.put("content", content);
		String jsonBody = commentparams.toString();
		return jsonBody;
	}
}
