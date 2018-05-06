package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//ENTRY 6;
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
}