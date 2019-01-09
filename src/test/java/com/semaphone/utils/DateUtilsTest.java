package com.semaphone.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class DateUtilsTest.
 */
public class DateUtilsTest {
    
    /**
     * Test add days.
     */
    @Test
    public void testAddDays() {
        // if we add 31 days to 8th Jan 2019, it should be 8th Feb 2019
        assertEquals(DateUtils.addDays(new Date(2019, 1, 8), 31), new Date(2019, 2, 8));
        
        // if we add 60 days to 8th Jan 2019, it should be 9th Mar 2019
        assertEquals(DateUtils.addDays(new Date(2019, 1, 8), 60), new Date(2019, 3, 9));
        
        // if we add 365 days to 8th Jan 2019, it should be 8th Jan 2020
        assertEquals(DateUtils.addDays(new Date(2019, 1, 8), 365), new Date(2020, 1, 8));
        
        // if we add 730 days to 8th Jan 2019, it should be 7th Jan 2021
        assertEquals(DateUtils.addDays(new Date(2019, 1, 8), 730), new Date(2021, 1, 7));
        
        assertEquals(DateUtils.addDays(new Date(2019, 1, 8), 1467), new Date(2023, 1, 14));
        
        // if we add 14 days to 20th Dec 2018, it should be 3rd Jan 2019
        assertEquals(DateUtils.addDays(new Date(2018, 12, 20), 14), new Date(2019, 1, 3));
        
        // if we add 0 days to 20th Dec 2018, it should be 20th Dec 2018
        assertEquals(DateUtils.addDays(new Date(2018, 12, 20), 0), new Date(2018, 12, 20));
        
        // Boundary Cases for Leap Years
        
        assertEquals(DateUtils.addDays(new Date(2020, 1, 1), 365), new Date(2020, 12, 31));
        
        assertEquals(DateUtils.addDays(new Date(2019, 12, 31), 365), new Date(2020, 12, 30));
        
        assertEquals(DateUtils.addDays(new Date(2020, 2, 28), 366), new Date(2021, 2, 28));
        
        assertEquals(DateUtils.addDays(new Date(2020, 2, 27), 367), new Date(2021, 2, 28));
        
        assertEquals(DateUtils.addDays(new Date(2019, 12, 12), 365), new Date(2020, 12, 11));
        
        assertEquals(DateUtils.addDays(new Date(2020, 2, 28), 365), new Date(2021, 2, 27));
        
        assertEquals(DateUtils.addDays(new Date(2020, 1, 1), 366), new Date(2021, 1, 1));
        
        assertEquals(DateUtils.addDays(new Date(2019, 2, 28), 365), new Date(2020, 2, 28));
    }
    
    /**
     * Test add days with exception.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testAddDaysWithException() {
        DateUtils.addDays(new Date(2019, 1, 8), -6);
    }
}
