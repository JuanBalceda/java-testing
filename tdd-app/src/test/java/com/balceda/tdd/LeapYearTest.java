package com.balceda.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jbalceda on Dec, 2018
 */
public class LeapYearTest {

    @Test
    public void leapYearsAreDivisibleByFour() {
        assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearsAreNotDivisibleByFour() {
        assertFalse(LeapYear.isLeapYear(3));
    }

    @Test
    public void leapYearsAreNotDivisibleByOneHundred() {
        assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearsAreDivisibleByFourHundred() {
        assertTrue(LeapYear.isLeapYear(2000));
    }
}
