package com.semaphone.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class DateUtilsTest.
 */
public class DateUtilsPerfTest {
    
    /**
     * Test add days.
     */
    @Test
    public void testAddDays() {
        assertEquals(DateUtilsPerf.addDays(new Date(2019, 1, 8), 3100), new Date(2027, 7, 5));
        
        assertEquals(DateUtilsPerf.addDays(new Date(2019, 1, 8), 6000), new Date(2035, 6, 13));
        
        // Boundary Cases for Leap Years
        
        assertEquals(DateUtilsPerf.addDays(new Date(2020, 1, 1), 365), new Date(2020, 12, 31));
        
        assertEquals(DateUtilsPerf.addDays(new Date(2019, 12, 31), 365), new Date(2020, 12, 30));
        
        assertEquals(DateUtilsPerf.addDays(new Date(2020, 2, 28), 366), new Date(2021, 2, 28));
        
        assertEquals(DateUtilsPerf.addDays(new Date(2020, 2, 27), 367), new Date(2021, 2, 28));
        
        assertEquals(DateUtilsPerf.addDays(new Date(2019, 12, 12), 365), new Date(2020, 12, 11));
        
        assertEquals(DateUtilsPerf.addDays(new Date(2020, 2, 28), 365), new Date(2021, 2, 27));
        
        assertEquals(DateUtilsPerf.addDays(new Date(2020, 1, 1), 366), new Date(2021, 1, 1));
    }
    
    /**
     * Test add days with exception.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testAddDaysWithException() {
        DateUtilsPerf.addDays(new Date(2019, 1, 8), -6);
    }
}
