/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Sadula Bineetha
 */
public class Deck extends GroupOfCards{
    
    public Deck() {
        super(52);
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        for (String suit : suits) {
            for (int val = 2; val <= 14; val++) {
                add(new StandardCard(val, suit));
            }
        }
    }
    
    
}
