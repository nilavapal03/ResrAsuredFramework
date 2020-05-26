package com.nilava.APIFramework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateAddress  {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(UpdateNewAddress.addressUpdate()).when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).header("Server", "Apache/2.4.18 (Ubuntu)")
		.header("Connection", "Keep-Alive").body("msg", equalTo("Address successfully updated"))
		.extract().response().asString();
		
		System.out.println("Update new address response:"+response);
		JsonPath js= new JsonPath(response);
		String new_Address=js.getString("msg");
		System.out.println("New Address added sucssfully msg is:"+new_Address);
		
		
		
		//To get the response 
		
		String response1=given().log().all().queryParam("place_id", Basic.placeId).queryParam("key", "qaclick123")
				.when().get("/maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
				
				System.out.println(response1);
				JsonPath json= new JsonPath(response1);
				String address= json.getString("address");
				System.out.println("New Updated address is:: "+address);
				
		

	}

}
