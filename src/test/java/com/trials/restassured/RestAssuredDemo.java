package com.trials.restassured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class RestAssuredDemo {

	public static void main(String[] args) {

//		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
//		https://reqres.in/

//		System.out.println("Response :- " + given().queryParam("userId", 1).get("posts").asString());

		given().spec(req)
		.queryParam("userId", 1)
		.get("posts")
		.then()
		.body("[0].userId", equalTo(1))
		.and()
		.body("[0].id", equalTo(1))
		.log().all();
	}
}