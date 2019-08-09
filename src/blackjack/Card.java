/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Harpreet Saund
 * @author Ashish Sharma
 * @author Anjali Ahuja
 * @author Simar Sheridan
 */
public class Card {
    private Suit suit;
    private GroupOfCards value;
    
    public Card(Suit suit, GroupOfCards value)
    {
        this.suit = suit;
        this.value = value;
    }
    public String toString()
    {
        return suit.toString() + " - " + this.value.toString();
    }
    
    public GroupOfCards getValue(){
        return value;
    }
}
