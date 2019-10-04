/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Harpreet Saund
 */
public class BlackJackTest {
    
    public BlackJackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkBetAmount method, of class BlackJack.
     */
    @Test
    public void testCheckBetAmountGood() {
        System.out.println("checkBetAmountGood");
        double pBet = 90;
        boolean expResult = true;
        boolean result = BlackJack.checkBetAmount(pBet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    @Test
      public void testCheckBetAmountBad() {
        System.out.println("checkBetAmountBad");
        double pBet = 120;
        boolean expResult = false;
        boolean result = BlackJack.checkBetAmount(pBet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }
      @Test
      public void testCheckBetAmountBoundry() {
        System.out.println("checkBetAmountBoundry");
        double pBet = 100;
        boolean expResult = true;
        boolean result = BlackJack.checkBetAmount(pBet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkChoice method, of class BlackJack.
     */
    @Test
    public void testCheckChoiceGood() {
        System.out.println("checkChoiceGood");
        int choice = 1;
        boolean expResult = true;
        boolean result = BlackJack.checkChoice(choice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCheckChoiceBad() {
        System.out.println("checkChoiceBad");
        int choice = 3;
        boolean expResult = false;
        boolean result = BlackJack.checkChoice(choice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCheckChoiceBoundry() {
        System.out.println("checkChoiceBoundry");
        int choice = 1;
        boolean expResult = true;
        boolean result = BlackJack.checkChoice(choice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

  
}
