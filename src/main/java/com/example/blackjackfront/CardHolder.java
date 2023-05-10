package com.example.blackjackfront;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class CardHolder {
    private ArrayList<Card> cards;
    Card firstCard;

    //Constructor for n full pack(s)
    public CardHolder(int n) {
        this.cards = new ArrayList<>();
        if (n != 0){
            for (int l = 0; l < n ; l++){
                for (int i = 0; i < Card.suitsList.size(); i++) {
                    for (int j = 0; j < Card.ranksList.size(); j++) {
                        StringBuilder sb = new StringBuilder();
                        String suit = Card.suitsList.get(i);
                        String rank = Card.ranksList.get(j);
                        sb.append(rank).append(suit);
                        Card uus = new Card(sb.toString());
                        cards.add(uus);
                    }
                }
            }
        }
        firstCard = cards.get(0);
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
        return (ArrayList<Card>) cards.clone();
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int size() {
        return getCards().size();
    }

    public Card takeCard() {
        if (!cards.isEmpty())
            return cards.remove(0);
        else throw new RuntimeException("CardHolder is empty");
    }
    public void addCard(Card card) {
        cards.add(card);
    }
    public int cardsToValue() {
        int value = 0;
        for (Card card : cards) {
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
    public Group makePack(BorderPane table){

        // Create a pack of cards on the rightmost part of the table
        Group pack = new Group();

        for (int i = 5; i >= 1; i--) {
            ImageView backImageAdd = loadBackImage();

            // Shift each additional image horizontally and vertically
            backImageAdd.setTranslateX(-2 * i);
            backImageAdd.setTranslateY(2 * i);

            // Bring the additional image to the back of the group
            backImageAdd.toBack();

            // Add the additional image to the group
            pack.getChildren().add(backImageAdd);
        }

        firstCard.setUp(false);
        firstCard.setFandB();
        pack.getChildren().add(firstCard.getFandB());

        BorderPane.setAlignment(pack, Pos.CENTER_LEFT);
        table.setLeft(pack);

        return pack;
    }

    public ImageView loadBackImage(){
        File backImageFile = new File("CardBack.jpg");
        String imagePath = backImageFile.toURI().toString();
        ImageView backImage = new ImageView(new Image(imagePath));
        backImage.setFitWidth(100);
        backImage.setFitHeight(167);

        return backImage;
    }
}
