package Activities;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

	
	@ExtendWith(PactConsumerTestExt.class)
	public class Activity5 {
	    // Create the contract(Pact)
	    @Pact(consumer = "UserConsumer", provider = "UserProvider")
	    public RequestResponsePact createPact(PactDslWithProvider builder) {        
	        String reqResBody = null;
			return builder.given("POSTRequest")
	            .uponReceiving("A request to add data")
	                .method("POST")
	                .path("/api/path")
	                .body(reqResBody)
	            .willRespondWith()
	                .status(200)
	                .body(reqResBody)
	            .toPact();
	    }

	    // Consumer test with mock provider
	    @SuppressWarnings("deprecation")
		@Test
	    @PactTestFor(providerName = "TestProvider", port = "9000")
	    public void postRequestTest() {
	        // Create a request body
	        Map<String, Object> reqBody = new HashMap<>();
	        reqBody.put("id", 123);
	        reqBody.put("firstName", "Taro");
	        reqBody.put("lastName", "Sakamoto");
	        reqBody.put("email", "sakamotodays@example.com");

	        // Send request, get response, assert response
	        given()
            .baseUri("http://localhost:9000/api/path")
            .body(reqBody)
            .log().all()
        .when()
            .post()
        .then()
            .statusCode(200)
            .body("lastName", equals("Sakamoto")).log().all();
    }

}
