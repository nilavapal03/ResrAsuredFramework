package com.nilava.APIFramework;

import java.io.IOException;

public class UpdateNewAddress {

	public static String address = "BH-164/1, Sarkar, Vidyasagar Pally, Palpara, Jorakhana, kestopur, Kolkata";

	public static String newAddress() throws IOException {
		return "{\r\n" + "\"place_id\":\"" +AddPlacePost.postAddPlace() + "\",\r\n" + " \"address\": \"" + address
				+ "\",\r\n" + "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "";
	}
}
