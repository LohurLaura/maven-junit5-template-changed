package org.example;

import Dto.LoggingDto;
import Dto.TestOrderDto;
import Helper.Authorization;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.example.LoggingFeatureTest.setupFunctions;

public class OrderCreationTest {
    static String token;
    @BeforeAll
    public static void setup(){
        token = Authorization.getToken();
        System.out.println("Token is here: " + token);

    }

    @Test
    public void createOrderTest(){

// Creating the instance of the login dto class
        TestOrderDto orderDto = new TestOrderDto("New order", 123456, "comment","123455", "Comment", 5);
// Serialization
        String orderDtoAsJson = new Gson().toJson(orderDto);

        given().
                log().
                all().
                header("Content-Type", "application/json").
                header("Authorization", "Bearer " + token).
                //header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsYXVyYSIsImV4cCI6MTcwMDAwMTQ3OSwiaWF0IjoxNjk5OTgzNDc5fQ.WHLl1s21iFt8Ow-j8UMIJxES90aSVYlMroD9hG2TH3vi56FIPnhkp8WyQp_xdV3XBx2aoWX_L6ZluqOB2ccU3w)").
                        body(orderDtoAsJson).
                post("http://51.250.6.164:8080/orders").
                then().
                log().
                all().
                        assertThat().
                        statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void getOrderById(){
        given().
                log().
                all().
                header("Content-Type", "application/json").
                //header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsYXVyYSIsImV4cCI6MTcwMDAwMTQ3OSwiaWF0IjoxNjk5OTgzNDc5fQ.WHLl1s21iFt8Ow-j8UMIJxES90aSVYlMroD9hG2TH3vi56FIPnhkp8WyQp_xdV3XBx2aoWX_L6ZluqOB2ccU3w)").
                        header("Authorization", "Bearer " + token).
                // body(orderDtoAsJson).
                        get("http://51.250.6.164:8080/orders/4827").
                        then().
                        log().
                        all().
                        assertThat().
                        statusCode(HttpStatus.SC_OK);
    }
}
