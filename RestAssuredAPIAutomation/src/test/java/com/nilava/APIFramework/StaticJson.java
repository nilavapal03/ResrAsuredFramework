package com.nilava.APIFramework;

import java.io.IOException;

import org.testng.annotations.Test;

import GenericUtils.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {

	@Test
	public void addPlace() throws IOException {
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=	RestAssured.given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(ReusableMethod.convertJsonToString("./payoads/addPlace.json")).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
		
	System.out.println("Response is:: "+response);
	
	JsonPath json= ReusableMethod.rawToJson(response);
	String placeId=json.getString("place_id");
	System.out.println("Place is is:: "+placeId);
	
	
	}
}
