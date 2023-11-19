package org.example;

import Dto.TestOrderDto;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderDtoPostTests {
    @Test
    public void CreatingOrderWithoutCourierIdField(){
        //Arrange
        String customerName = "Some name";
        TestOrderDto testOrderDtoConstructorForTests = new TestOrderDto("Open",4, customerName, "333222", "This comment", 2);

        //Serialization
        String testOrderDtoAsJsonForTests = new Gson().toJson(testOrderDtoConstructorForTests);

        Response response = given().
                log().
                all().
                header("Content-Type", "application/json").
                //header("Bearer Token", "TOKEN_VALUE").
        body(testOrderDtoAsJsonForTests).
                post("http://51.250.6.164:8080/test-orders/").
                then().
                log().
                all().
                extract().
                response();

        //Deserialization
        TestOrderDto orderReceived = new Gson().fromJson(response.asString(),TestOrderDto.class);

        assertAll(
        "Grouped Assertions of User",
               () -> assertEquals("This comment", orderReceived.getComment(), "1st Assert"),
              () -> assertEquals(customerName, orderReceived.getCustomerName(), "2nd Assert")
         );

        Assertions.assertEquals("OPEN",orderReceived.getStatus());
        Assertions.assertEquals(customerName, orderReceived.getCustomerName());
        Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }
}
