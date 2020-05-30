package com.nilava.APIFramework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.Assert;

import GenericUtils.ReusableMethod;

public class UpdateAddress {

	public static void main(String[] args) throws IOException {
		
		//to update the address
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(UpdateNewAddress.newAddress()).when().put("/maps/api/place/update/json").then().assertThat()
				.statusCode(200).extract().response().asString();

		System.out.println(response);
		JsonPath json = ReusableMethod.rawToJson(response);
		String msg = json.getString("msg");
		System.out.println("New Address successfully added msg is :: " + msg);

		// To get the or verify updated address.

		System.out.println("======================== Get method executed ========================");
		String response1 = given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", AddPlacePost.placeId).header("Content-Type","application/json").when().get("/maps/api/place/get/json").then().log().all()
				.assertThat().statusCode(200)
				.header("Server", "Apache/2.4.18 (Ubuntu)").header("Connection", "Keep-Alive").
				
				body("types", equalTo("shoe park,shop")).extract().response().asString();

		System.out.println(response1);
		JsonPath js = ReusableMethod.rawToJson(response1);
		String actual_Address = js.getString("address");
		System.out.println("New updated address is:: " + actual_Address);
		Assert.assertEquals(actual_Address, UpdateNewAddress.address, "Pass");

	}

}
