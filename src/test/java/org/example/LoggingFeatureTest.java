package org.example;

import Dto.LoggingDto;
import Dto.TestOrderDto;
import Helper.SetupFunctions;
import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoggingFeatureTest {
    static SetupFunctions setupFunctions;
    @BeforeAll
    public static void setup(){
        setupFunctions = new SetupFunctions();
        System.out.println("Username: " + setupFunctions.getUsername());
        System.out.println("Password: " + setupFunctions.getPassword());
    }


    @Test
    public void successfulLoginTest(){

// Creating the instance of the login dto class
        LoggingDto login = new LoggingDto(setupFunctions.getUsername(), setupFunctions.getPassword() );
// Serialization
        String loggingDtoAsJson = new Gson().toJson(login);

        given().
                log().
                all().
                header("Content-Type", "application/json").
                body(loggingDtoAsJson).
                post("http://51.250.6.164:8080/login/student").
                then().
                log().
                all().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void unsuccessfulLoginTest(){

        LoggingDto login = new LoggingDto(setupFunctions.getUsername(), "hello");

        String loggingDtoAsJson = new Gson().toJson(login);

        given().
                log().
                all().
                header("Content-Type", "application/json").
                body(loggingDtoAsJson).
                post("http://51.250.6.164:8080/login/student").
                then().
                log().
                all().
                assertThat().
                statusCode(HttpStatus.SC_UNAUTHORIZED);

    }


}
