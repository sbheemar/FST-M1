package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslRequestWithoutPath;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    // Set the headers
    Map<String, String> headers = new HashMap<>();

    // Create the contract(Pact)
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        // Set headers
        headers.put("Content-Type", "application/json");
        // Create the JSON body
        DslPart reqResBody = new PactDslJsonBody()
            .numberType("id", 123)
            .stringType("firstName", "Saahil")
            .stringType("lastName", "Sharma")
            .stringType("email", "saahil@example.com");
        // Create the contract(Pact)
        return builder.given("POST Request")
            .uponReceiving("A request to create a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(reqResBody)
            .willRespondWith()
                .status(201)
                .body(reqResBody)
            .toPact();
    }

    // Consumer test with mock provider
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void postRequestTest() {
        // Create a request body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 123);
        reqBody.put("firstName", "Saahil");
        reqBody.put("lastName", "Sharma");
        reqBody.put("email", "saahil@example.com");

        // Send request, get response, assert response
        given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all().
        when().post().
        then().statusCode(201).body("email", equalTo("saahil@example.com")).log().all();
    }
}