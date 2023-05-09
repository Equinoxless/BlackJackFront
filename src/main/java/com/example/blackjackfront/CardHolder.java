package com.example.blackjackfront;

import java.util.ArrayList;
import java.util.Collections;

public class CardHolder {
    private ArrayList<Card> Cards;

    //Constructor for n full pack(s)
    public CardHolder(int n) {
        this.Cards = new ArrayList<>();
        if (n != 0){
            for (int l = 0; l < n ; l++){
                for (int i = 0; i < Card.suitsList.size(); i++) {
                    for (int j = 0; j < Card.ranksList.size(); j++) {
                        StringBuilder sb = new StringBuilder();
                        String suit = Card.suitsList.get(i);
                        String rank = Card.ranksList.get(j);
                        sb.append(rank).append(suit);
                        Card uus = new Card(sb.toString());
                        Cards.add(uus);
                    }
                }
            }

        }
    }

    //Method to identify whether there are same cards in the deck
    public boolean sameCards(ArrayList<Card> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                String first = list.get(i).toString();
                String second = list.get(j).toString();
                if (first.equals(second)  && i != j)
                    return true;
            }
        }
        return false;
    }
    public ArrayList<Card> getCards() {
        return (ArrayList<Card>) Cards.clone();
    }
    public void shuffle() {
        Collections.shuffle(Cards);
    }

    public int size() {
        return getCards().size();
    }

    public Card takeCard() {
        if (!Cards.isEmpty())
            return Cards.remove(0);
        else throw new RuntimeException("CardHolder is empty");
    }
    public void addCard(Card card) {
        Cards.add(card);
    }
    public int cardsToValue() {
        int value = 0;
        for (Card card : Cards) {
            String suit = card.getSuit();
            switch (suit) {
                case "K", "Q", "J", "10" -> value += 10;
                case "9" -> value += 9;
                case "8" -> value += 8;
                case "7" -> value += 7;
                case "6" -> value += 6;
                case "5" -> value += 5;
                case "4" -> value += 4;
                case "3" -> value += 3;
                case "2" -> value += 2;
                default -> {
                }
            }
        }
        return value;
    }
}
