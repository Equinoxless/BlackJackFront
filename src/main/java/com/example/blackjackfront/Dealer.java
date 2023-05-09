package com.example.blackjackfront;

public class Dealer extends Hooman{
    private Card firstCard;

    @Override
    public void hit(Card card) {
        // when taking first crad we need to remember it to show it to the player.
        if (super.getCardsOnHand().size() == 0){
            this.firstCard = card;
        } else if (super.getCardsOnHand().size() >= 2) {
            System.out.println("Diiler otsustas võtta kaardi");
        }
        super.hit(card);
    }


    public void showFirstCard(){
        System.out.println("Diileri esimene kaart on: " + firstCard.toString());
    }
}
