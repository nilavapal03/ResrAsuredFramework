package GenericUtils;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {

	public static JsonPath rawToJson(String response) {
		JsonPath jsonpath = new JsonPath(response);
		return jsonpath;
	}

}
