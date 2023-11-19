package org.example;

public class CardValueMapper {
        public static int getCardValue(String cardRank) {
                switch (cardRank.toUpperCase()) {
                        case "JACK":
                                return 11;
                        case "QUEEN":
                                return 12;
                        case "KING":
                                return 13;
                }
                return 0;
        }
}