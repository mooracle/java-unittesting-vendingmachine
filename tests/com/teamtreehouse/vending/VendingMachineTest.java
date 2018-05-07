package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

//ENTRY 10;
/** ENTRY 10: WHAT TO TEST
 *  1.  Now we are going to make a Stub (or a stunt double for class) to test the vending machine
 *  2.  First we need to create a class inside VendingMachine class to represents Interface notifier
 *  3.  The other remains the same but in this case notifier will be asked in the VendingMachine initialization
 *  4.  Other setUp is just work as usual and please also add @Rule ExpectedException we just going to ensure all
 *  5.  I know it is boring but hey no harm to do it we just test NotEnoughFundExceptions
 *
 *  */

public class VendingMachineTest {
    private VendingMachine vendingMachine;

    public class NotifierStub implements Notifier {
        @Override
        public void onSale(Item item) {
            //just return it it's a void and it should not return anything for the test
            return;
        }
    }

    //10-4;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        Notifier notifier = new NotifierStub();
        vendingMachine = new VendingMachine(notifier, 10, 10, 10);
        vendingMachine.restock("A1", "Cheetos", 10, 100, 150);
    }

    @Test
    public void vendTheRightItem() throws Exception {
        vendingMachine.addMoney(150);

        Item item = vendingMachine.vend("A1");

        assertEquals("Cheetos", item.getName());
    }

    @Test
    public void vendTwiceThenRefundMoney() throws Exception {
        vendingMachine.addMoney(500);

        vendingMachine.vend("A1");
        vendingMachine.vend("A1");

        assertEquals("refunding", 200, vendingMachine.refundMoney());
    }

    @Test
    public void vendingTwiceNotEnoughMoneyInvokesException() throws Exception {
        //10-4;
        expectedException.expect(NotEnoughFundsException.class);

        vendingMachine.addMoney(200);
        vendingMachine.vend("A1");
        vendingMachine.vend("A1");
    }
}