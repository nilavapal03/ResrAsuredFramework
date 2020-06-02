package GenericUtils;





import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {

	public static JsonPath rawToJson(String response) {
		JsonPath jsonpath = new JsonPath(response);
		return jsonpath;
	}
	
	public static String convertJsonToString(String path) throws IOException {
		 return new String(Files.readAllBytes(Paths.get(path)));
	}

	
	public static void compareJson(File path1, File path2) throws IOException {
		String expectedJson=FileUtils.readFileToString(path1);
		String actualJson=FileUtils.readFileToString(path2);
		System.out.println(actualJson);
	}
}
