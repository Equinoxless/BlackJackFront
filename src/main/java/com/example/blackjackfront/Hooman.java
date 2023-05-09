package com.example.blackjackfront;

import java.util.ArrayList;

public class Hooman {
    private CardHolder cardsOnHand;

    public Hooman() {
        this.cardsOnHand = new CardHolder(0);
    }

    public void hit(Card card) {
        cardsOnHand.addCard(card);
    }

    public int calculatePoints(){
        int sum = 0;
        int numOfAces = 0;

        for (Card card : cardsOnHand.getCards()){
            if (card.getRank().equals("K") || card.getRank().equals("Q") || card.getRank().equals("J")){
                sum += 10;
            } else if (card.getRank().equals("A")) {
                numOfAces += 1;
            } else {
                sum += Integer.parseInt(card.getRank());
            }
        }

        if ((sum + numOfAces*11) <= 21){
            sum += numOfAces*11;
        } else {
            sum += numOfAces*1;
        }

        return sum;
    }

    public boolean checkLose(){
        if (calculatePoints() > 21) {
            return true;
        }
        return false;
    }

    public ArrayList<Card> getCardsOnHand() {
        return cardsOnHand.getCards();
    }
}
