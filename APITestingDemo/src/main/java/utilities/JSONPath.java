package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JSONPath {

		public static JsonPath covertToJSON(Response response) {
			String resString = response.asString();
			JsonPath js = new JsonPath(resString);
			return js;
		}
}
