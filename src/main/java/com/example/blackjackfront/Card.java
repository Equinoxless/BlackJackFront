package com.example.blackjackfront;

import java.util.List;
import java.util.Arrays;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;

public class Card {
    private String rank;
    private String suit;
    private ImageView backImage;
    private Group frontImage;
    private Group FandB;    //contains front and back images, needed for rotating cards only, therefore
                            //is instantiated (via setter) only when needed
    private boolean isUp;   //also needed only for rotating cards and is instantiated (via setter) only when needed

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
            this.backImage = loadImage("CardBack.jpg", 100, 167);
            this.frontImage = front();
            this.FandB = new Group();
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

    public ImageView getBackImage() {
        return backImage;
    }
    public Group getFrontImage() {
        return frontImage;
    }

    public Group getFandB() {
        return this.FandB;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public void setFandB() {
        this.FandB.getChildren().add(backImage);
        this.FandB.getChildren().add(frontImage);
        if(isUp)
            backImage.setVisible(false);
        else frontImage.setVisible(false);
    }

    //toString
    public String toString() {
        return rank + suit;
    }

    // loads whatever image needed and sets its width and height
    public ImageView loadImage(String imageName, int width, int height){
        File backImageFile = new File(imageName);
        String imagePath = backImageFile.toURI().toString();
        ImageView backImage = new ImageView(new Image(imagePath));
        backImage.setFitWidth(width);
        backImage.setFitHeight(height);

        return backImage;
    }
    // makes the frontal image of the card
    public Group front(){
        VBox cardContent = new VBox();
        Group cardPic = new Group();

        Text valueText = new Text(this.rank);
        valueText.setFont(Font.font("Arial", FontWeight.BOLD, 50));

        String suitFile;
        switch (this.suit) {
            case "♣" -> suitFile = "clubs.png";
            case "♦" -> suitFile = "diamonds.png";
            case "♠" -> suitFile = "spades.png";
            case "♥" -> suitFile = "hearts.png";
            default -> suitFile = null;
        }

        ImageView suitImage = loadImage(suitFile, 50, 50);

        cardContent.getChildren().addAll(valueText, suitImage);

        Rectangle background = new Rectangle(100, 167, Color.GHOSTWHITE);

        cardPic.getChildren().addAll(background, cardContent);

        return cardPic;
    }
}