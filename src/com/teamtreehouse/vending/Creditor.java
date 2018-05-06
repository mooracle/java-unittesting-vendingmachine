package com.teamtreehouse.vending;

/** ENTRY 1: SETTING A PROJECT FOR TESTS
 *  1.  we need to build separate folder for test. here we go
 *  2.  right click on the Java-unisetting…. root directory and choose new|directory| named it tests
 *  3.  The we make that directory by right clicking on the test directory and choose mark directory as
 *      | Test Sources Root
 *  4.  From a class name just right click and pick Goto|Test(Ctrl+Shift+T)
 *  5.  choose Create New Test
 *  6.  Choose Yes (for now) when asked create test from the same root?
 *  7.  In the create Test pop up window choose Testing Library as: JUnit4
 *  8.  The JUnit4 if it is not found in the module : fix it click the button fix
 *  9.  Choose Use JUnit4 for IntelliJ distribution
 *  10. Then let us just select one method to be tested in this case refund
 *  11. It will create new test Class inside the tests folder
 *  NEXT: ENTRY 2: RUNNING TESTS AND READING OUTPUTS GOTO: com/teamtreehouse/vending/CreditorTest.java
 * */
public class Creditor {
    private int funds;

    public Creditor() {
        funds = 0;
    }

    public void addFunds(int money) {
        funds += money;
    }

    public void deduct(int money) throws NotEnoughFundsException {
        if (money > funds) {
            throw new NotEnoughFundsException();
        }
        funds -= money;
    }

    public int refund() {
        int refund = funds;
        funds = 0;
        return refund;
    }

    public int getAvailableFunds() {
        return funds;
    }

}
