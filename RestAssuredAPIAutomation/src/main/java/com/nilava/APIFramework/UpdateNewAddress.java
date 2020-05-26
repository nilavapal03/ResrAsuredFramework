package com.nilava.APIFramework;

public class UpdateNewAddress {
	
	public static String address="BH-200/1, Vidyasagarpally, Palpara, jorakhana, Kolkata 700102";
	public static String addressUpdate() {
	
	return  "{\r\n" + 
			"\"place_id\":\""+Basic.placeId()+"\",\r\n" + 
			" \"address\": \""+address+"\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}\r\n" + 
			"";
	}

}


