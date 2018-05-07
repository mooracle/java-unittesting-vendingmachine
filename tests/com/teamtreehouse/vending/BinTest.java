package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

//ENTRY 8;
/** ENTRY 8: KNOW YOUR BOUNDS
 *  1.  We are now want to test the Bin function. Declare private Bin object
 *  2.  Thus we need to put some @Rules to suppress all the dynamic Exceptions (@Rules comes after ExpectedException)
 *  3.  Then we setUp some @Before instantiation of Bin(int maxCap) object
 *  4.  Build @Test when the bin is restocked with different brand items it will invoke IllegalArgumentException
 *  5.  The IllegalArgumentException will five message "Cannot restock Cheetos with Doritos" since the restock are them
 *  6.  Next we are gonna test for assertEqual getName with the name "Cheetos"
 *  7.  next assertEqual getItemPrice expected 150
 *  8.  next assertEqual Wholesale price after Item being released.
 *  9.  next @Test if the item is not restocked and empty it will return null in getItemName
 *  10. next @Test if the item is not restocked the getItemPrice will be NullIlegalException
 *  11. next we test if the stock exceed available slots should invoke IllegalArgumentException with message
 *  GOTO: com/teamtreehouse/vending/CreditorTest.java ENTRY 9: TESTING NOT ENOUGH FUNDS EXCEPTION
 * */

public class BinTest {
    //8-1;
    private Bin bin;

    //8-2;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    //8-3;
    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    //8-4;
    @Test
    public void differentBrandRestockedException() throws Exception {
        //8-5;
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Cannot restock Doritos with Cheetos");
        bin.restock("Doritos", 2, 100, 150);
        bin.restock("Cheetos", 5, 100, 150);
    }

    //8-6;
    @Test
    public void getNameAfterRestock() throws Exception {
        bin.restock("Cheetos", 5, 100, 150);
        Item item = bin.release();

        assertEquals("name", "Cheetos", bin.getItemName());
        //8-7;
        assertEquals("Item Price", 150, bin.getItemPrice());
        //8-8;
        assertEquals("wholesale price", 100, item.getWholesalePrice());
        assertEquals("item persistence price", item.getRetailPrice(), bin.getItemPrice());
    }

    //8-9;
    @Test
    public void binEmptyReturnsNameNull() throws Exception {
        assertNull(bin.getItemName());
    }

    //8-10;
    @Test
    public void name() {
        expectedException.expect(NullPointerException.class);
        bin.getItemPrice();
    }

    //8-11;
    @Test
    public void restockExceedsAvailableSlotsInvokesException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("There are only 5 spots left");
        bin.restock("Cheetos", 5, 100, 150);
        bin.restock("Cheetos", 7, 100, 150);
    }
}