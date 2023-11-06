package org.example;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

public class OrderControllerTest {
    @Test
    public void successGettingOrder(){
        given()
                .log()
                .all()
                .when()
                .get("http://51.250.6.164:8080/test-orders/1")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void noSuccessGettingOrder(){
        given()
                .log()
                .all()
                .when()
                .get("http://51.250.6.164:8080/test-orders/15")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,5,9,10})
    public void successGettingOrderAndCheckResponseCode(int orderId){

        String URL = "http://51.250.6.164:8080/test-orders/" + orderId;

        given()
                .log()
                .all()
                .when()
                .get("http://51.250.6.164:8080/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @ParameterizedTest
    @ValueSource (ints = {-1,0,11,12})
    public void noSuccessGettingOrderAndCheckingResponseCode(int orderId){

        String URL = "http://51.250.6.164:8080/test-orders/" + orderId;

        given()
                .log()
                .all()
                .when()
                .get("http://51.250.6.164:8080/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
