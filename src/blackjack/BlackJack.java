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
public class BlackJack {
    
  static double pMoney  = 100;//This is the player money that the player has at beginning.
    public static boolean checkBetAmount(double pBet)//Method to check amount that player wants to bet
    {
        if(pBet >pMoney)
           {
               System.out.println("You can't bet more than u have.");
               return false;
           }
        else
            return true;
    }
    public static boolean checkChoice(int choice)// Method to check what choice the player has made
    {
        if(choice==1||choice==2)
        {
            return true;
        }
        else{
             System.out.println("You have only two options stand or hit.");
             return false;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the BlackJack game.");
        Deck pl = new Deck();//playing deck
        Deck pd  = new Deck();//player deck
        Deck dd = new Deck();//dealer deck
        pl.createDeck();
        pl.shuffle();
        
        
       while(pMoney>0)
       {
           System.out.println("You have $"+pMoney+"\n"+"Enter the amount for bet.");
           double pBet =sc.nextDouble();//playerbet
           if(pBet > pMoney)
           {
               System.out.println("You can't bet more than u have.");
               break;
           }
           boolean endR = false;
           pd.draw(pl);
           pd.draw(pl);
            dd.draw(pl); 
            dd.draw(pl);
            
            while(true)
            {
                System.out.println("Your hand: "+pd.toString());//showing user hand
                System.out.println("Value of your deck is: "+pd.cardValue());//showing users card value
                System.out.println("Dealer's hand: "+dd.getCard(0).toString()+"and [Hidden]");
                
                System.out.println("Enter 1 if u want to hit.");
                System.out.println("Enter 2 if u want to stand.");
                int choice = sc.nextInt();   //getting user choice
                
                if(choice == 1)
                {
                    pd.draw(pl);
                    System.out.println("Your draw a: "+pd.getCard(pd.deckSize()-1).toString());
                    if(pd.cardValue()>21)
                    {
                        System.out.println("Bust. Currently valued at: " +pd.cardValue());
                        pMoney -= pBet;
                        endR = true;
                    }
                }
                if(choice == 2)
                {
                    break;
                }
                
            }
           System.out.println("Dealer cards: " +dd.toString());
           if((dd.cardValue() > pd.cardValue())&& endR == false)
           {
               System.out.println("Dealer has beaten u!");
               pMoney -= pBet;
               endR =true;
           }
           while((dd.cardValue()<17)&& endR==false)
           {
               dd.draw(pd);
               System.out.println("Dealer draw: "+dd.getCard(dd.deckSize()-1).toString());
           }
           System.out.println("Dealer's hand is valued at: " +dd.cardValue());
           if((dd.cardValue()>21)&& endR == false){
               System.out.println("Dealer busts! YOU WIN!");
               pMoney += pBet;
               endR = true;
           }
           if((pd.cardValue()==dd.cardValue())&&endR==false)
           {
               System.out.println("PUSH");
               endR = true;
           }
           if((pd.cardValue()>dd.cardValue())&&endR==false)
           {
               System.out.println("You WIN the hand!");
               pMoney += pBet;
               endR = true;
           }
           else if(endR ==false)
           {
               System.out.println("You loose the hand!");
               pMoney -= pBet;
               endR=true;
           }
           pd.moveToDeck(pl);
           dd.moveToDeck(pl);
           System.out.println("End of the hand!");
       }
       System.out.println("Game Over\n You don't have any money!");
        
    }
    
}
