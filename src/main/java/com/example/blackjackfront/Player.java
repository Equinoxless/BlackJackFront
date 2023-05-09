package com.example.blackjackfront;

import java.util.Scanner;

public class Player extends Hooman{
    public void showStatus(){
        // TODO: check does this look right
        System.out.println("Sinu kaardid on: ");
        for (Card card : getCardsOnHand()){
            System.out.print(card.getRank() + card.getSuit() + ", ");
        }
    }

    public String whatToDoNext(){
        String input;
        while (true){
            System.out.println("Mida teed järgmisena? Kui soovid võtta kaardi, siis kirjuta 'HIT', kui aga soovid jääda selle summaga, siis kirjuta 'PASS'");
            Scanner scan = new Scanner(System.in);
            input = scan.next();
            if (!input.equalsIgnoreCase("hit") && !input.equalsIgnoreCase("pass") ){
                System.out.println("Sisestatud tegevus on vigane.");
            } else {
                break;
            }
        }
        return input;
    }
}
