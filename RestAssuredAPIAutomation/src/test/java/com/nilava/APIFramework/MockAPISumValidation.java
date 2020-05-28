package com.nilava.APIFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import GenericUtils.ReusableMethod;
import io.restassured.path.json.JsonPath;

public class MockAPISumValidation {

	//Verify if Sum of all Course prices matches with Purchase Amount
	@Test
	public void sumOfCourses() {
		int totalAmount = 0;

		JsonPath json = ReusableMethod.rawToJson(PayLoad.mockAPIBody());
		int purchaseAmount = json.getInt("dashboard.purchaseAmount");
		int count = json.getInt("courses.size()");
		System.out.println("Total course count is:: " + count);
		for (int i = 0; i < count; i++) {
			String title = json.getString("courses[" + i + "].title");
			int price = json.getInt("courses[" + i + "].price");
			int copies = json.getInt("courses[" + i + "].copies");
			System.out.println("Title of the course is:: " + title);
			System.out.println("Price of the course is:: " + price);
			System.out.println("Copies of the course is:: " + copies);
			int mul = price * copies;
			System.out.println("Multiply of the sum is:: " + mul);
			System.out.println("===============================================================");
			totalAmount = totalAmount + mul;
		}

		System.out.println("Total amount is:: " + totalAmount);
		Assert.assertEquals(totalAmount, purchaseAmount);
	}

}
