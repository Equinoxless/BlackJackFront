package com.example.blackjackfront;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.util.List;

public class FrontRow {

    CardHolder cards;

    public FrontRow(CardHolder cards) {
        this.cards = cards;
    }

    public HBox makeRow(){
        // Create a row of cards and add stuff to it
        HBox cardrow = new HBox(10);
        for (Card c : cards.getCards()) {
            Group frontImage = c.getFrontImage();
            cardrow.getChildren().add(frontImage);
        }
        return cardrow;
    }
    public void makeBotRow(BorderPane table){
        HBox cardrow = this.makeRow();
        // Position the card row at the bottom center of the table
        BorderPane.setAlignment(cardrow, Pos.CENTER);
        table.setBottom(cardrow);
    }
    public void makeTopRow(BorderPane table){
        HBox cardrow = this.makeRow();
        // Position the card group at the top center of the table
        BorderPane.setAlignment(cardrow, Pos.CENTER);
        table.setTop(cardrow);
    }
}
