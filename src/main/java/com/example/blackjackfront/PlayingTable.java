package com.example.blackjackfront;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;


public class PlayingTable extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the root layout (green table)
        BorderPane tableLayout = new BorderPane();
        tableLayout.setPadding(new Insets(10));
        tableLayout.setStyle("-fx-background-color: green");
        primaryStage.setTitle("Blackjack Table");

        CardHolder playerHand = new CardHolder(1);
        FrontRow fr1 = new FrontRow(playerHand);
        fr1.makeBotRow(tableLayout);

        CardHolder dealerHand = new CardHolder(1);
        FrontRow fr2 = new FrontRow(dealerHand);
        fr2.makeTopRow(tableLayout);

        CardHolder gamePack = new CardHolder(1);
        gamePack.makePack(tableLayout);

        // Create the scene and show the stage
        Scene scene = new Scene(tableLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        RotateTransition rotator = createRotator(gamePack.getFirstCard().getBackImage(), gamePack.getFirstCard().getFrontImage());
        rotator.play();
    }
    public RotateTransition createRotator(ImageView backImage, Group frontImage) {
        RotateTransition rotator = new RotateTransition(Duration.millis(750), backImage);
        rotator.setAxis(Rotate.Y_AXIS);
        rotator.setFromAngle(0);
        rotator.setToAngle(90);
        rotator.setInterpolator(Interpolator.LINEAR);

        rotator.setOnFinished(event -> {
            backImage.setVisible(false);
            frontImage.setVisible(true);
        });

        return rotator;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
