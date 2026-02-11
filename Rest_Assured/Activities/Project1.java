package Project1;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GitHubSSHKeyTest {

    RequestSpecification requestSpec;
    String sshKey;
    int keyId;

    @BeforeClass
    public void setup() {

        // Your SSH public key
        sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICmdghz/txw8mIZv65NXP0183/kLKleowp7ZrJWZOvF6";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType("application/json")
                .addHeader("Authorization", "token <YOUR_GITHUB_ACCESS_TOKEN>")
                .build();

        RestAssured.requestSpecification = requestSpec;
    }

    @Test(priority = 1)
    public void createSSHKey() {

        String requestBody = "{\n" +
                "  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response =
                given()
                        .body(requestBody)
                .when()
                        .post("/user/keys")
                .then()
                        .extract()
                        .response();

        Reporter.log("POST Response: " + response.asString(), true);

        Assert.assertEquals(response.getStatusCode(), 201);

        keyId = response.jsonPath().getInt("id");
        Assert.assertTrue(keyId > 0, "SSH key ID should be generated");
    }

    @Test(priority = 2)
    public void getSSHKey() {

        Response response =
                given()
                        .pathParam("keyId", keyId)
                .when()
                        .get("/user/keys/{keyId}")
                .then()
                        .extract()
                        .response();

        Reporter.log("GET Response: " + response.asString(), true);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), keyId);
    }

    @Test(priority = 3)
    public void deleteSSHKey() {

        Response response =
                given()
                        .pathParam("keyId", keyId)
                .when()
                        .delete("/user/keys/{keyId}")
                .then()
                        .extract()
                        .response();

        Reporter.log("DELETE Status Code: " + response.getStatusCode(), true);

        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
