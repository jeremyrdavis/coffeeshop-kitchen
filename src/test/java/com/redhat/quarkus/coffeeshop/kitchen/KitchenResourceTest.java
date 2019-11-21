package com.redhat.quarkus.coffeeshop.kitchen;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class KitchenResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/kitchen")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}