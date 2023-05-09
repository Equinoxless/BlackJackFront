package com.example.blackjackfront;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class FrontEnd extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the root layout (green table)
        BorderPane tableLayout = new BorderPane();
        tableLayout.setPadding(new Insets(10));
        tableLayout.setStyle("-fx-background-color: green");

        CardHolder ch = new CardHolder(1);
        List<Card> cards = ch.getCards();
        FrontRow fr = new FrontRow(cards);
        fr.makeBotRow(tableLayout);
        fr.makeTopRow(tableLayout);

        FrontPack fp = new FrontPack(cards);
        fp.makePack(tableLayout);

        // Create the scene and show the stage
        Scene scene = new Scene(tableLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blackjack Table");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
