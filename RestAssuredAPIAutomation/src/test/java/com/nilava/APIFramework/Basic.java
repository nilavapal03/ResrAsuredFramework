package com.nilava.APIFramework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Basic {

	static String placeId;
	public static String placeId() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(PayLoad.addPlace()).when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.body("status", equalTo("OK")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		System.out.println("Rresponse is:"+response);
		JsonPath js= new JsonPath(response);
		placeId=js.getString("place_id");
		System.out.println("Place id is:: "+placeId);
		return placeId;

	}

}
