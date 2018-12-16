package com.balceda.tdd;

/**
 * Created by jbalceda on Dec, 2018
 */
public class LeapYear {

    public static boolean isLeapYear(final int year) {
        return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year,400));
    }

    private static boolean isDivisible(final int year,final int denominator) {
        return year % denominator == 0;
    }
}