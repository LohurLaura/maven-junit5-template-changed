package org.example;

import Dto.TestOrderDto;
import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiMockTest {
    @Test
    public void testWithBody(){

        //Dto creation with constructor
        TestOrderDto order = new TestOrderDto("OPEN", 5, "Name", "33333", "Comment", 2);

        //Dto creation with constructor by default and setters
        TestOrderDto testOrderDtoSetter = new TestOrderDto();
        testOrderDtoSetter.setComment("New comment");
        testOrderDtoSetter.setCustomerName("New name");
        testOrderDtoSetter.setCustomerPhone("44444");
        testOrderDtoSetter.setId(5);
        testOrderDtoSetter.setCourierId(4);
        testOrderDtoSetter.setStatus("Also open");

        //Serialization
        String testOrderDtoAsJson = new Gson().toJson(order);

        given().
                log().
                all().
                header("Content-Type", "application/json").
                body(testOrderDtoAsJson).
                post("http://51.250.6.164:8080/test-orders/").
                then().
                log().
                all().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }
}
