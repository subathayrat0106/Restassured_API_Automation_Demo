package apiproject.company_route;

import org.json.JSONObject;

public class Payload {
	
	public static String companyPayload(String name, String suffix, String url, String accountName, String accountNum) {
		String bodyJson = "{"
				+ "\"name\": \"%s\","
				+ "\"suffix\": \"%s\","
				+ "\"url\": \"%s\","
				+ "\"finance\": {"
				+ "\"account_name\": \"%s\","
				+ "\"account_number\": \"%s\" }"
				+"}";
		return String.format(bodyJson, name,suffix,url,accountName,accountNum);
	}
	
	public static String companyPayload_JsonObject(String name, String suffix, String url, String accountName, String accountNum) {
		JSONObject requestparams = new JSONObject();
		JSONObject authparam = new JSONObject();
		
		requestparams.put("name", name);
		requestparams.put("suffix", suffix);
		requestparams.put("suffix", url);
		
		authparam.put("account_name",accountName);
		authparam.put("account_number", accountNum);
		
		requestparams.put("finance", authparam);
		String jsonBody = requestparams.toString();
		return jsonBody;
	}

}
