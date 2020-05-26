package com.nilava.APIFramework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import GenericUtils.ReusableMethod;

public class AddPlacePost {

	public static String placeId;

	public static String postAddPlace() {
		System.out.println("======================== post method executed ========================");
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayLoad.addPlace()).when().post("/maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).header("Server", "Apache/2.4.18 (Ubuntu)").body("status", equalTo("OK")).extract()
				.response().asString();

		System.out.println(response);

		JsonPath jsonpath = ReusableMethod.rawToJson(response);
		placeId = jsonpath.getString("place_id");
		System.out.println("Place id is:: " + placeId);
		return placeId;
	}

}
