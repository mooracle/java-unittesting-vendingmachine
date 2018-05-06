package com.teamtreehouse.vending;

import org.junit.Test;

import static org.junit.Assert.*;

//ENTRY 2;
/** ENTRY 2: RUNNING TESTS AND READING OUTPUTS
 *  1.  One thing you need to add to this test class is the throws Exception and change the test method to testRefund()
 *      NOTE: I know this is not the best practice but please play along for now
 *  2.  Then we can initialize test run by right click the tests directory and click Run.
 *      After this we can just press the run icon button since it will be set to run all the main and the test
 *  3.  Now we are going to test if it really can fail by using the org.junit.Assert method called fail().
 *      NOTE: since org.junit.Assert.* is an import static package you can just code the method name ie: fail() without
 *          need to use Assert.fail() for instance since it was already static (instantiated, loaded when compiled)
 *  NEXT: ENTRY 3: ASSERTIONS
 *
 *  ENTRY 3: ASSERTIONS
 *  1.  Now let's build a real test: adding funds will add to available funds
 *  2.  rename the testRefund to addingFundsInrementsAvailabelFunds
 *  3.  Delete the fail() method to give space for the real test implementing the AAA principle of:
 *      a.  Arrange: create the new Creditor object named creditro
 *      b.  Act : the creditor.addFunds() of 25 cents twice
 *      c.  Asserts: assertsEquals expected is 50 real is creditor.getAvailable Funds (assertEquals is part of
 *          or.junit.Assert.* static imports thus can be readily called!
 *  4.  NOTE: CHECK THE Creditor class for each methods
 *  5.  Next we test the refund() methods of the Creditor class. since it still in the same test class we just create
 *      another @Test method. Alt+Insert choose test method
 *  6.  In the new test method rename it and add throws Exception
 *  7.  Back to the AAA principle
 *      a.  Arrange:-create new creditor (remember each test method is isolated to another)
 *                  -make the creditor add some fund to created availableFunds
 *      b.  Act: make the creditor to refund and catch the amount (int) of refund
 *      c.  Assert: assert getAvailableFunds returns 0 and also refund() method returns exactly all funds
 *  8.  WARNING: This is bad practice to hold two assertions in one test! Assertion is just like Execption it will make
 *              all program halt if one has found error in one of two assertion. We will not even tests the second
 *              assertion if the first has failed. We need to fix this NEXT
 *  NEXT: ENTRY 4: SINGLE ASSERTIONS MAKES BETTER TEST
 *
 * */

public class CreditorTest {

    @Test
    //2-1(deleted);3-2;
    public void addingFundsInrementsAvailabelFunds() throws Exception {
        //2-3(deleted); 3-3a;
        Creditor creditor = new Creditor();

        //3-3b;
        creditor.addFunds(25);
        creditor.addFunds(25);

        //3-3c;
        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    //3-6;
    public void refundingReturnsAllAvailbleFunds() throws Exception {
        //3-7a;
        Creditor creditor = new Creditor();
        creditor.addFunds(25);

        //3-7b;
        int refund = creditor.refund();

        //3-7c;
        assertEquals(0,creditor.getAvailableFunds());
        assertEquals(25, refund);
    }
}