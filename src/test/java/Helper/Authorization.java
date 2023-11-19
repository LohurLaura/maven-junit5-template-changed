package Helper;

import Dto.LoggingDto;
import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authorization {

    public static String getToken() {

        SetupFunctions setupFunctions = new SetupFunctions();
        LoggingDto loggingDto = new LoggingDto(setupFunctions.getUsername(), setupFunctions.getPassword());

        // serialization
        String testLoggingDtoAsJson = new Gson().toJson(loggingDto);

        Response response = given().
                log().
                all().
                header("Content-Type", "application/json").
                body(testLoggingDtoAsJson).
                post("http://51.250.6.164:8080/login/student").
                then().
                extract().
                response();

        return response.asString();
    }
}
