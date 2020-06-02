package com.nilava.JiraAPI;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GenericUtils.ReusableMethod;
import PayLoadsForJiraAPI.PayLoads;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class Authentication {
	String Issueid = "";
	String addCommentId = "";
	String totalId = "";

	@BeforeTest
	public void authenticationJira() {
		SessionFilter session = new SessionFilter();
		System.out.println(
				"==============================Authentication starts=============================================");
		RestAssured.baseURI = "http://localhost:8081";
		String response = RestAssured.given().log().all().header("Content-Type", "application/json")
				.body(PayLoads.authenticationBody()).filter(session).when().post("/rest/auth/1/session").then().log()
				.all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		JsonPath json = ReusableMethod.rawToJson(response);
		String name = json.getString("session.name");
		String value = json.getString("session.value");
		totalId = name + "=" + value;

		System.out.println("Session name is:: " + name);
		System.out.println("Session value is:: " + value);

		System.out.println(totalId);
		System.out.println(
				"==============================Authentication ends=============================================");

	}

	@Test(priority = 1, enabled = true)
	public void createIssueInJira() {
		System.out.println(
				"==============================Create Issue in Jira starts=============================================");
		RestAssured.baseURI = "http://localhost:8081";
		String response = RestAssured.given().log().all().header("Content-Type", "application/json")
				.header("cookie", totalId).body(PayLoads.createIssueBody()).when().post("/rest/api/2/issue").then()
				.log().all().assertThat().statusCode(201).extract().response().asString();

		JsonPath json1 = ReusableMethod.rawToJson(response);

		Issueid = json1.getString("id");
		String key = json1.getString("key");
		System.out.println("Id is:: " + Issueid);
		System.out.println("Key is:: " + key);
		System.out.println(
				"==============================End create issue in ends=============================================");

	}

	@Test(priority = 2, enabled = true)
	public void addCommnetInJira() {
		System.out.println(
				"==============================Add commnet in jira starts=============================================");
		RestAssured.baseURI = "http://localhost:8081";
		String response1 = RestAssured.given().log().all().pathParam("id", Issueid)
				.header("Content-Type", "application/json").header("cookie", totalId).body(PayLoads.addCommentBody())
				.when().post("/rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201).extract()
				.response().asString();
		System.out.println(response1);
		JsonPath js = ReusableMethod.rawToJson(response1);
		addCommentId = js.getString("id");
		System.out.println("issue id is:: " + addCommentId);
		System.out.println(
				"==============================Add commnet in jira ends=============================================");

		// this is code for update comment in jira

		System.out.println(
				"==============================update commnet in Jira starts=============================================");
		RestAssured.baseURI = "http://localhost:8081";
		RestAssured.given().log().all().pathParam("id", Issueid).pathParam("issueID", addCommentId)
				.header("Content-Type", "application/json").header("cookie", totalId).body(PayLoads.updateCommentBody())
				.when().put("/rest/api/2/issue/{id}/comment/{issueID}").then().log().all().assertThat().statusCode(200);
		System.out.println(
				"==============================udate comment in jira ends=============================================");

	}

	@Test(priority = 3, enabled = true)
	public void attachmentInJira() {
		System.out.println(
				"==============================Attachment in jira scripts starts=============================================");
		RestAssured.baseURI = "http://localhost:8081";
		RestAssured.given().log().all().pathParam("id", Issueid).header("cookie", totalId)
				.header("Content-Type", "multipart/form-data").header("X-Atlassian-Token", "no-check")
				.multiPart("file", new File("./resources/attachments/Issue.PNG")).when()
				.post("/rest/api/2/issue/{id}/attachments").then().log().all().assertThat().statusCode(200);

		System.out.println(
				"==============================Attachment in jira scripts ends=============================================");
	}

	// this is for delete issue from jira

	@Test(priority = 4, enabled = true)
	public void deleteIssueFromJira() {
		System.out.println(
				"==============================Delete issue script starts=============================================");
		RestAssured.baseURI = "http://localhost:8081";
		RestAssured.given().log().all().pathParam("id", Issueid).header("Content-Type", "application/json")
				.header("cookie", totalId).when().delete("/rest/api/2/issue/{id}").then().log().all().assertThat()
				.statusCode(204);
		System.out.println(
				"==============================Delete issue script ends=============================================");

	}

}
