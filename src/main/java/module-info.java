module com.example.blackjackfront {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.blackjackfront to javafx.fxml;
    exports com.example.blackjackfront;
}