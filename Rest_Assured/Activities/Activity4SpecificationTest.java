package examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;



public class Activity4SpecificationTest {
	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId;
	
	@BeforeClass
	public void setUp() {
		//Request Specification
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-Type", "application/json").
				build();
				
		//Response Specification
		responseSpec = 	new ResponseSpecBuilder().
				expectStatusCode(200).
				expectResponseTime(lessThanOrEqualTo(5000L)).
				build();
						
	}
	
	//POST https://petstore.swagger.io/v2/pet
	@Test (priority = 1)
	
	public void postResponse() {
		//Create a Request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 12332);
		reqBody.put("name", "BlackDog");
		reqBody.put("status", "alive");
		
		Response response = given().spec(requestSpec).body(reqBody).when().post();
		
		//Extract the Pet ID
		petId = response.then().extract().path("id");
		
		//Assertions
		response.then().spec(responseSpec).body("status", equalTo("alive")).log().all();
				
	}
	
	//Get https://petstore.swagger.io/v2/pet/{petId}
	@Test (priority = 2)
	
	public void getRequest() {
		//Send request, get response, assert response
		given().spec(requestSpec).pathParam("petId", petId).log().uri().
		when().get("/{petId}").
		then().spec(responseSpec).body("status", equalTo("alive")).log().all();
		
	}
	
	//Delete https://petstore.swagger.io/v2/pet/{petID}
	@Test (priority = 3)
	
	public void deleteResponse() {
		//Delete petID
		given().spec(requestSpec).pathParam("petId", petId).log().uri().
		when().delete("/{petId}").
		then().spec(responseSpec).body("message", equalTo(""+petId)).log().all();
	}

}
