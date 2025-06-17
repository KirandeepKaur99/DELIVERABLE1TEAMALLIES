
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.List;

/**
 *
 * @author Sadula Bineetha
 */
public class WarPlayer extends Player{
    
    private GroupOfCards hand;

    public WarPlayer(String name) {
        super(name);
        // start with an empty hand
        this.hand = new GroupOfCards(0);
    }

    /** Adds one card to the bottom of this player’s hand */
    public void addCard(Card c) {
        hand.add(c);
    }

    /** Draws and returns the top card (or null if empty) */
    public Card playCard() {
        return hand.draw();
    }

    /** @return whether this player still has cards left */
    public boolean hasCards() {
        return !hand.isEmpty();
    }

    /** @return how many cards remain in this player’s hand */
    public int cardsLeft() {
        return hand.count();
    }

    @Override
    public void play() {
        // Not used in our WarGame loop
    }
}