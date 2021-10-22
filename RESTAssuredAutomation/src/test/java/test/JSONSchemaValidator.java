package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;

public class JSONSchemaValidator {
	
		@Test
	
		public void getUsers2() {
			
			baseURI = "https://reqres.in/api";
			
			given().
				get("/users?page=2").
		    then().
		    	assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		    	statusCode(200).
		    body("data[1].id",equalTo(8));
		}

}
