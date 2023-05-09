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


public class FrontPack {

    List<Card> cards;

    public FrontPack(List<Card> cards) {
        this.cards = cards;
    }

    public Group makePack(BorderPane table){

        // Create a pack of cards on the rightmost part of the table
        Group pack = new Group();

        ImageView backImage = loadImage("CardBack.jpg");

        pack.getChildren().add(backImage);

        for (int i = 1; i <= 5; i++) {
            ImageView backImageAdd = loadImage("CardBack.jpg");

            // Shift each additional image horizontally and vertically
            backImageAdd.setTranslateX(2 * i);
            backImageAdd.setTranslateY(-2 * i);

            // Bring the additional image to the back of the group
            backImageAdd.toBack();

            // Add the additional image to the group
            pack.getChildren().add(backImageAdd);
        }


        BorderPane.setAlignment(pack, Pos.CENTER_LEFT);
        table.setLeft(pack);

        return pack;
    }
    public ImageView loadImage(String imageName){
        File backImageFile = new File("CardBack.jpg");
        String imagePath = backImageFile.toURI().toString();
        ImageView backImage = new ImageView(new Image(imagePath));
        backImage.setFitWidth(100);
        backImage.setFitHeight(167);

        return backImage;
    }
}
