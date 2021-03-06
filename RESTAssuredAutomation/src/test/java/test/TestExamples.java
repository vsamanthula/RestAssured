package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestExamples {
	
	//@Test
	public void getUsers() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
			
	}
	
	//@Test
	public void getUsers2() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
	    then().
	    	statusCode(200).
	    body("data[1].id",equalTo(8));
	}
	
	
	//@Test
	public void postUsers() {
		baseURI = "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("name", "Venkat");
		request.put("job", "leader");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
		    log().all();
	}
	
	//@Test
	public void putUsers() {
		baseURI = "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("name", "Venkat");
		request.put("job", "leader");
		
		given().
		    contentType(ContentType.JSON).
            accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
		  
	}
	
	//@Test
	public void patchUsers() {
		baseURI = "https://reqres.in";
		
		JSONObject request = new JSONObject();
		request.put("name", "Venkat");
		request.put("job", "leader");
		
		given().
		    contentType(ContentType.JSON).
            accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();
		  
	}
	
	@Test
	public void deleteUsers() {
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
			log().all();
		  
	}

}
