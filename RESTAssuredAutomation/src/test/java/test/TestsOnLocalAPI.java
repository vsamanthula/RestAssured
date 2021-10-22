package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
	
	//@Test
	public void getUsers() {
		
		baseURI = "http://localhost:3000";
		
		given().
		get("/users").
		then().
		statusCode(200).
		log().all();
		
	}
	
	
	@Test
	public void postUsers() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Thomas");
		request.put("lastName", "Edison");
		request.put("subjectId", 1);
		
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
	
	@Test
	public void putUsers() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Albert");
		request.put("lastName", "Einstein");
		request.put("subjectId", 2);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/5").
	    then().
	    statusCode(200).
	    log().all();
	    	
	}
	
	@Test
	public void patchUsers() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();	
		
		request.put("lastName", "Edi");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/5").
	    then().
	    statusCode(200).
	    log().all();
	    	
	}
	
	@Test
	public void deleteUser() {
		
		baseURI = "http://localhost:3000";
		
		when().
			delete("/users/5").
	    then().
	    statusCode(200).
	    log().all();
	    	
	}

}
