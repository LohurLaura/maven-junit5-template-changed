package org.example;

import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class BlackJack {
    public static void main(String[] args) {

        Response response =

                given().
                        log().
                        all().
                        get("https://deckofcardsapi.com/api/deck/new/").
                        then().
                        log().
                        all().
                        assertThat().
                        extract().
                        response();

        // Deserialization
        BlackJackDeckDto result = new Gson().fromJson(response.asString(), BlackJackDeckDto.class);

        String deckId = result.getDeck_id();

        String urlForCards = "https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=6";

        String urlForShuffling = "https://deckofcardsapi.com/api/deck/" + deckId + "/shuffle/";
        //Shuffling
        given().
                log().
                all().
                get(urlForShuffling).
                then().
                log().
                all();
        //Drawing cards
        Response responseCards =

                given().
                        log().
                        all().
                        get(urlForCards).
                        then().
                        log().
                        all().
                        assertThat().
                        extract().
                        response();


        // Parse the JSON response using JsonPath
        JsonPath jsonPath = JsonPath.from(response.asString());

        // Extract the ArrayList of "value"
        ArrayList<String> valuesList = jsonPath.get("cards.value");

        // Convert ArrayList to String[]
        String[] values = valuesList.toArray(new String[0]);

    }
}

