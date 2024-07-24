package liveProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;





@ExtendWith(PactConsumerTestExt.class)

public class Activity5PactConsumerTest {
	//Set the header
	Map<String, String> headers = new HashMap<String, String>();
	
	//Create the contract(Pact)
	@Pact(consumer = "UserConsumer", provider = "UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		//Set the headers
		headers.put("Content-Type", "application/json");
		//Create the request and response body
		DslPart requestResponseBody = new PactDslJsonBody().
			numberType("id", 123).
			stringType("firstName", "Johnny").
			stringType("lastName", "Walker").
			stringType("email", "johnnywalker@test.com");
		//Create the contract
		return builder.given("POST Reauest").
			uponReceiving("request to create user").
			method("POST").
			path("/api/users").
			headers(headers).
			body(requestResponseBody).
			willRespondWith().
			status(201).
			body(requestResponseBody).
			toPact();

	}	
	
	//Consumer test with mock provider
	@Test
	@PactTestFor(providerName = "UserProvider", port = "8282")
	public void postRequestTest(){
		//Create a Request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 123);
		reqBody.put("firstName", "Johnny");
		reqBody.put("lastName", "Walker");
		reqBody.put("email", "johnnywalker@test.com");
		//Send a request, get response, assert response
		given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all().
		when().post().
		then().statusCode(201).body("id", equalTo(123)).log().all();
						
	}

}
