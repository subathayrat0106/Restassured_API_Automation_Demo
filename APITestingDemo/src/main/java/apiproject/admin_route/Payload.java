package apiproject.admin_route;

import org.json.JSONObject;

public class Payload {

		public static String adminPayload(String email, String password) {
			JSONObject json_payload = new JSONObject();
			json_payload.put("email", email);
			json_payload.put("password", password);
			
			return json_payload.toString();
		}
}
