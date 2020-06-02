package com.nilava.APIFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import GenericUtils.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddBook {

	String bookId = "";

	
	
	@Test(enabled = true, dataProvider = "addbook")
	
	public void addBook(String isbn, String aisle) {

		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().log().all().header("Content-Type", "application/json")
				.body(PayLoad.insertBook(isbn, aisle)).when().post("Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		System.out.println(res);

		JsonPath json = ReusableMethod.rawToJson(res);
		bookId = json.getString("ID");
		System.out.println("Book id is:: " + bookId);
	}

	@Test(priority = 1, enabled = true)
	public void getBook() {
		System.out.println("============Get the book==============");
		RestAssured.baseURI = "http://216.10.245.166";
		String res1 = given().log().all().queryParam("AuthorName", "Nilava").header("Content-Type", "application/json")
				.when().get("/Library/GetBook.php").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(res1);
		JsonPath js1 = ReusableMethod.rawToJson(res1);
		int count = js1.getInt("array.size()");

		System.out.println("Book name associate with Author name is :: " + count);

		for (int i = 0; i < count; i++) {
			System.out.println("Book name is:: " + js1.getString("[" + i + "].book_name"));
			System.out.println("isbn id is:: " + js1.getString("[" + i + "].isbn"));
			System.out.println("aisle id is:: " + js1.getString("[" + i + "].aisle"));
			System.out.println("=============================================================");
		}

	}

	@Test(priority = 2, enabled = true)
	public void deleteBook() {

		System.out.println("======Delete Book API starts from here======");
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().body(PayLoad.deleBook(bookId)).when().post("/Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);

		JsonPath js = ReusableMethod.rawToJson(response);
		String messgae = js.getString("msg");
		System.out.println("Delete message is:: " + messgae);
		// Assert.assertEquals(messgae, expected);
	}

	@DataProvider(name = "addbook")
	public Object[][] getData() {

		return new Object[][] { { "abcdq", "3456" }, { "rtyui", "6768" }, { "sweety", "5678" }, { "cuteee", "5657" } };
	}

}
