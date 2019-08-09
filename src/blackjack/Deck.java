/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.*;

/**
 *
 * @author Harpreet Saund
 * @author Ashish Sharma
 * @author Anjali Ahuja
 * @author Simar Sheridan
 */
public class Deck {
    
    private ArrayList<Card> cards;
    
    public Deck()
    {
        this.cards = new ArrayList<Card> ();
    }
    
    public void createDeck(){
        for(Suit cardSuit : Suit.values())
        {
            for(GroupOfCards cardVal : GroupOfCards.values())
            {
                this.cards.add(new Card(cardSuit, cardVal));
            }
        }
    }
    
    public void shuffle()
    {
        ArrayList<Card> tmpDeck = new ArrayList();
        Random rd = new Random();
        int rndN=0;
        int size = this.cards.size();
        for(int i=0;i<size ;i++)
        {
              rndN = rd.nextInt((this.cards.size()-1-0)+1)+0;
              tmpDeck.add(this.cards.get(rndN));
              this.cards.remove(rndN);
        }
        this.cards=tmpDeck;
    }
    
    public void removeCard(int i)
    {
        this.cards.remove(i);
    }
    
    public int deckSize(){
        return this.cards.size();
    }
    public void moveToDeck(Deck move)
    {
        int deckSize = this.cards.size();
        for(int i=0; i<deckSize ;i++)
        {
            move.addCard(this.getCard(i));
        }
        for(int i=0; i<deckSize ;i++)
        {
            this.removeCard(0);
        }
    }
    public Card getCard(int i)
    {
        return this.cards.get(i);
    }
    
    public void addCard(Card card)
    {
        this.cards.add(card); 
    }
    
    public void draw(Deck card)
    {
        this.cards.add(card.getCard(0));
        card.removeCard(0);
    }
    public String toString(){
        String str = "";
        for(Card sCard : this.cards)
        {
            str += "\n"+ " " +sCard.toString();
        }
        return str;
    }
    
    public int cardValue(){
        int totalValue = 0;
        int aces = 0;
        
        for(Card sCard : this.cards)
        {
            switch(sCard.getValue())
            {
                case TWO:
                {
                    totalValue +=2; 
                    break;
                }
                case THREE:
                {
                    totalValue +=3; 
                    break;
                }
                case FOUR:
                {
                    totalValue +=4; 
                    break;
                }
                case FIVE:
                {
                    totalValue +=5; 
                    break;
                }
                case SIX:
                {
                    totalValue +=6; 
                    break;
                }
                case SEVEN:
                {
                    totalValue +=7; 
                    break;
                }
                case EIGHT:
                {
                    totalValue +=8; 
                    break;
                }
                case NINE:
                {
                    totalValue +=9; 
                    break;
                }
                case TEN:
                {
                    totalValue +=10; 
                    break;
                }
                case JACK:
                {
                    totalValue +=10; 
                    break;
                }
                case QUEEN:
                {
                    totalValue +=10; 
                    break;
                }
                case KING:
                {
                    totalValue +=10; 
                    break;
                }
                case ACE:
                {
                    aces += 1; 
                    break;
                }
            }
            for(int i = 0;i <aces ;i++)
            {
                if(totalValue >10)
                    totalValue += 1;
                else
                    totalValue += 11;
            }  
        }
        return totalValue;
    }
}
