package com.nilava.APIFramework;

public class PayLoad {

	public static String addPlace() {
		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
				+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "";
	}

	public static String mockAPIBody() {
		return "{\r\n" + "  \"dashboard\": {\r\n" + "    \"purchaseAmount\": 3810,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n" + "  },\r\n" + "  \"courses\": [\r\n" + "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n" + "      \"price\": 50,\r\n" + "      \"copies\": 6\r\n"
				+ "    },\r\n" + "    {\r\n" + "      \"title\": \"Cypress\",\r\n" + "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n" + "    },\r\n" + "    {\r\n" + "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n" + "      \"copies\": 10\r\n" + "    },\r\n" + "    {\r\n"
				+ "      \"title\": \"Appium\",\r\n" + "      \"price\": 60,\r\n" + "      \"copies\": 30\r\n"
				+ "    },\r\n" + "   {\r\n" + "      \"title\": \"RestAssured API\",\r\n" + "      \"price\": 55,\r\n"
				+ "      \"copies\": 20\r\n" + "    }\r\n" + "  ]\r\n" + "}";

	}
	
	public static String insertBook(String isbn, String aisle) {
		return "{\r\n" + "\"name\":\"Appium with Java\",\r\n" + "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n" + "\"author\":\"Nilava Pal\"\r\n" + "}\r\n" + "";
	}
	
	public static String deleBook(String id) {
		return "{\r\n" + "\r\n" + "\"ID\" : \"" + id + "\"\r\n" + "\r\n" + "} \r\n" + "";
	}
}
