package Activities;

public void Activity4() {
@Test
public void LoggingRequestBody() {
    String reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";

    Response response = given()
        .log().body() // Log request body
        .spec(requestSpec) // Use requestSpec
        .contentType(ContentType.JSON) // Set headers
        .body(reqBody) // Add request body
        .when().post(); // Send POST request
 
}

public void loggingResponseBody() {
    Response response = given()
      .spec(requestSpec) // Use requestSpec
      .pathParam("petId", "77232") // Set path parameter
      .get("/{petId}"); // Send GET request

    // Assertion with response specification
    response.then()
    .log().body() // Log only response body
    .spec(responseSpec); // Use resposeSpec for validation
}
}