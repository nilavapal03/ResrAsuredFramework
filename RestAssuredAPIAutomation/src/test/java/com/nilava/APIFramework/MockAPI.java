package com.nilava.APIFramework;

import org.testng.Assert;

import GenericUtils.ReusableMethod;
import io.restassured.path.json.JsonPath;

public class MockAPI {
	public static void main(String[] args) {

		JsonPath json = ReusableMethod.rawToJson(PayLoad.mockAPIBody());
		String amount = json.getString("dashboard.purchaseAmount");
		System.out.println(amount);
		String websiteName = json.getString("dashboard.website");
		System.out.println(websiteName);
		String courseDetails = json.getString("courses[0]");
		System.out.println(courseDetails);

		String courseTitle = json.getString("courses[0].title");
		System.out.println(courseTitle);

		String coursePrice = json.getString("courses[0].price");
		System.out.println(coursePrice);

		String courseCopies = json.getString("courses[0].copies");
		System.out.println(courseCopies);

		int firstCourseCoipes = Integer.parseInt(courseCopies);
		int firsttCoursePrice = Integer.parseInt(coursePrice);
		int sum = firstCourseCoipes * firsttCoursePrice;
		System.out.println(sum);

		String SeconedcourseDetails = json.getString("courses[1]");
		System.out.println(SeconedcourseDetails);

		String SeconedcourseTitle = json.getString("courses[1].title");
		System.out.println(SeconedcourseTitle);

		int SeconedcoursePrice = Integer.parseInt(json.getString("courses[1].price"));
		System.out.println(SeconedcoursePrice);

		int SeconedcourseCopies = Integer.parseInt(json.getString("courses[1].copies"));
		System.out.println(SeconedcourseCopies);

		String thirdcourseDetails = json.getString("courses[2]");
		System.out.println(thirdcourseDetails);

		String thirdcourseTitle = json.getString("courses[2].title");
		System.out.println(thirdcourseTitle);

		int thirdcoursePrice = Integer.parseInt(json.getString("courses[2].price"));
		System.out.println(thirdcoursePrice);

		int thirdcourseCopies = Integer.parseInt(json.getString("courses[2].copies"));
		System.out.println(thirdcourseCopies);

		int sum1 = SeconedcoursePrice * SeconedcourseCopies;
		System.out.println(sum1);
		int sum2 = thirdcoursePrice * thirdcourseCopies;
		System.out.println(sum2);
		int total = sum + sum1 + sum2;
		String totalAmount = Integer.toString(total);
		System.out.println(totalAmount);
		Assert.assertEquals(amount, totalAmount);

		// I want to fetch all courses as the json format is dynamic

		System.out.println("============ New code start from here ============");
		int count = json.getInt("courses.size()");
		System.out.println(count);

		int coursesPrice=0, coursesCopies=0, multiply=0;
		for (int i = 0; i < count; i++) {
			System.out.println("Course Title is:: " + json.get("courses[" + i + "].title"));
			 coursesPrice=json.getInt("courses[" + i + "].price");
			 coursesCopies= json.getInt("courses[" + i + "].copies");
			System.out.println("Course Price is:: " +coursesPrice);
			System.out.println("Course copies is:: " +coursesCopies);
			 multiply=coursesPrice*coursesCopies;
			System.out.println("Multiply is:: "+multiply);
			System.out.println("================================================================");
		}
		
		
		// Now I want to fetch only RPA courses copies as RPA courses is dynamic in json
		// body

		System.out.println("Print no of copies sold by RPA Course\r\n" + 
				"");
		
		for (int j = 0; j < count; j++) {
			if (json.get("courses[" + j + "].title").equals("RPA")) {
				System.out.println("RPA Course Copies is:: " + json.getInt("courses[" + j + "].copies"));
				break;
			}else {
				System.out.println("let's see what happen!!!!!!");
			}
		}

	}

}
