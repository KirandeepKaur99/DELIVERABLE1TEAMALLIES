/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Sadula Bineetha
 * @author Komalpreet Kaur Komalpreet Kaur
 */
public class StandardCard extends Card implements Comparable<StandardCard> {
    
    
    private int value;     // 2–14 (11=Jack,12=Queen,13=King,14=Ace)
    private String suit;   // "Hearts", "Diamonds", etc.

    public StandardCard(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String rank;
        switch (value) {
            case 11: rank = "Jack";  break;
            case 12: rank = "Queen"; break;
            case 13: rank = "King";  break;
            case 14: rank = "Ace";   break;
            default: rank = String.valueOf(value);
        }
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(StandardCard o) {
        return Integer.compare(this.value, o.value);
    }
}

   


