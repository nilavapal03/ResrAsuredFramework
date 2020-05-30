package GenericUtils;





import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {

	public static JsonPath rawToJson(String response) {
		JsonPath jsonpath = new JsonPath(response);
		return jsonpath;
	}
	
	public static String convertJsonToString(String path) throws IOException {
		 return new String(Files.readAllBytes(Paths.get(path)));
	}

}
