package com.nilava.APIFramework;

public class UpdateNewAddress {

	public static String address = "BH-164/1, Sarkar, Vidyasagar Pally, Palpara, Jorakhana, kestopur, Kolkata";

	public static String newAddress() {
		return "{\r\n" + "\"place_id\":\"" +AddPlacePost.postAddPlace() + "\",\r\n" + " \"address\": \"" + address
				+ "\",\r\n" + "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "";
	}
}
