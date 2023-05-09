package com.example.blackjackfront;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.util.List;

public class FrontRow {

    List<Card> cards;

    public FrontRow(List<Card> cards) {
        this.cards = cards;
    }

    public HBox makeRow(){

        // Create a row of cards and add stuff to it
        HBox cardrow = new HBox(10);
        for (Card c : cards) {
            VBox cardContent = new VBox();
            Group cardPic = new Group();

            Text valueText = new Text(c.getRank());
            valueText.setFont(Font.font("Arial", FontWeight.BOLD, 50));

            String suitFile;
            switch (c.getSuit()) {
                case "♣" -> suitFile = "clubs.png";
                case "♦" -> suitFile = "diamonds.png";
                case "♠" -> suitFile = "spades.png";
                case "♥" -> suitFile = "hearts.png";
                default -> suitFile = null;
            }
            File suitImageFile = new File(suitFile);
            String imagePath = suitImageFile.toURI().toString();
            ImageView suitImage = new ImageView(new Image(imagePath));
            suitImage.setFitWidth(50);
            suitImage.setFitHeight(50);

            cardContent.getChildren().addAll(valueText, suitImage);

            Rectangle background = new Rectangle(100, 167, Color.GHOSTWHITE);

            cardPic.getChildren().addAll(background, cardContent);

            cardrow.getChildren().add(cardPic);
        }
        return cardrow;
    }
    public void makeBotRow(BorderPane table){
        HBox cardrow = this.makeRow();
        // Position the card group at the bottom center of the table
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
