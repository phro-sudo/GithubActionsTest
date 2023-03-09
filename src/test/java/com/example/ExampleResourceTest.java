package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void testPrimeEndpoint() {
        given()
                .when().get("/prime/isPrime/10")
                .then()
                .statusCode(200)
                .body(is("false"));

        given()
                .when().get("/prime/isPrime/7")
                .then()
                .statusCode(200)
                .body(is("true"));

        given()
                .when().get("/prime/isPrime/797862515633589521029493836928")
                .then()
                .statusCode(200)
                .body(is("false"));

        given()
                .when().get("/prime/isPrime/797862515633589521029493836927")
                .then()
                .statusCode(200)
                .body(is("true"));

        given()
                .when().get("/prime/isPrime/7")
                .then()
                .statusCode(200)
                .body(is("false"));

    }

}