package rw.ac.rca.calcapp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MathControllerEndToEndTest {

    @LocalServerPort
    private int port;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Test
    void testDoMathEndToEnd() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        DoMathRequest request = new DoMathRequest(5, 3, "*");

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post(contextPath + "/api/math/doMath")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("calcResponse", equalTo(15.0));
    }
}
