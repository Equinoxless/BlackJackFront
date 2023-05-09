package com.example.blackjackfront;

public class Main {
    public static void main(String[] args) {
        BlackJack.showRules();
        int difficulty = BlackJack.readDifficultyInput();
        BlackJack blackjack = new BlackJack(difficulty);
        blackjack.start();
    }
}