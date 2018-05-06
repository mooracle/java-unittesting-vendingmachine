package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//ENTRY 6; ENTRY 7
/** ENTRY 6: THE HAPPY PATH AND BEYOND
 *  1.  This one is to test AlphaNumericChooser class which extended abstract class AbstractChooser
 *  2.  We will test the validity of the chooser and the precision of the row and column return
 *  3.  We start by defining a field of AlphaNumericChooser named chooser
 *  4.  Then in @Before method we will initialize it please NOTE that the constructor required to provide max col & row.
 *  5.  Next we will test the Location chooser.
 *  6.  to do this we need to define Location. Please remember that Location is a class inside abstract class
 *      AbstractChooser. Since AlphaNumericChoser is extending that same abstract class we can call it directly from
 *      AlphaNumericChooser class. we name it loc and it takes input from chooser.locationFromInput(String input) method
 *  7.  Asserts the row and column that produced (note they are both int since the alphabetical code for column will
 *      also being calculated to provide int location index)
 *
 *  ENTRY 7: EXCEPTION
 *  1.  We also need to ensure that when Exception does happen the proper designated Exception really does invoked
 *  2.  We will test two InvalidLocationException supposedly thrown when the input to location is not valid
 *  3.  First we test if the input is both alphabetic and expect InvalidLocationException which extends Exception
 *  4.  we set chooser to create locationFromInput of "AJ"
 *  5.  Next we build another test that expect similar exception but this time when input is out of the max limit
 *  6.  we set chooser to locationFromInput of "J22"
 *
 * PRE-REQ ENTRY 8: KNOW YOUR BOUNDS
 *  1.  We will test the Bin Class which responsible to oversee the container management like making sure all items
 *      inside the bin is the same.
 *  2.  We need to make a test for the Bin.java class
 *  GOTO: com/teamtreehouse/vending/BinTest.java for ENTRY 8
 * */
public class AlphaNumericChooserTest {
    //6-3;
    AlphaNumericChooser chooser;

    //6-4;
    @Before
    public void setUp() throws Exception {
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        //6-6;
        AlphaNumericChooser.Location location = chooser.locationFromInput("B4");

        //6-7;
        assertEquals("row test", 1, location.getRow());
        assertEquals("column test", 3, location.getColumn());
    }

    //7-3;
    @Test(expected = InvalidLocationException.class)
    public void invalidInputInvokesException() throws Exception {
        //7-4;
        chooser.locationFromInput("AJ");
    }

    //7-5;
    @Test(expected = InvalidLocationException.class)
    public void overLimitInputInvokesException() throws Exception {
        //7-6;
        chooser.locationFromInput("J22");
    }
}