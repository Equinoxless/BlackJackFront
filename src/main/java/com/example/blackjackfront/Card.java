package com.example.blackjackfront;

import java.util.List;
import java.util.Arrays;

public class Card {
    private String rank;
    private String suit;

    final public static String[] ranks = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    final public static List<String> ranksList = Arrays.asList(ranks);
    final public static String[] suits = {"♣", "♦", "♠", "♥"};
    final public static List<String> suitsList = Arrays.asList(suits);

    //Constructor
    public Card(String rankSuit) {
        StringBuilder sb = new StringBuilder(rankSuit);
        String r = sb.substring(0, sb.length()-1);
        String s = sb.substring(sb.length()-1);
        if ( ranksList.contains(r) && suitsList.contains(s) ) {
            this.rank = r;
            this.suit = s;
        }
        else throw new RuntimeException("This card doesn't exist");
    }

    //Getters
    public String getRank() {
        return rank;
    }
    public String getSuit() {
        return suit;
    }
    //toString
    public String toString() {
        return rank + suit;
    }
}