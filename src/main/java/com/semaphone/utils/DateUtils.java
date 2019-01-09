package com.semaphone.utils;

/**
 * The Class DateUtils.
 */
public class DateUtils {
    
    /** The Constant daysInMonth. */
    private static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    /**
     * Resolving year calculation.
     * For amount of days which exceeds a year, we resolve the count of year first.
     *
     * @param date the date
     * @param amount the amount
     * @return the date
     */
    public static Date addDays(final Date date, final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Days to be added should be zero or more");
        }
        
        int days = date.getDay() + amount;
        int month = date.getMonth();
        int year = date.getYear();
        
        return addDaysByMonth(year, month, days);
    }

    /**
     * Adds the days by month.
     *
     * @param year the year
     * @param month the month
     * @param days the days
     * @return the date
     */
    private static Date addDaysByMonth(int year, int month, int days) {
        
        if (days > 0 && days <= getDaysInMonth(month, year))
            return new Date(year, month, days);
        else {
            days = days - getDaysInMonth(month, year);
            month = month + 1;
            if (month > 12) {
                month = 1;
                year = year + 1;
            }
        }
        return addDaysByMonth(year, month, days);
    }

    /**
     * Gets the number of days in month.
     *
     * @param month
     *            the month
     * @param year
     *            the year
     * @return the no of days in month
     */
    private static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month-1];
    }

    /**
     * Checks for a year to be leap. A year is considered to be leap if it is
     * divisible by 4 and not by 100 or any year which is divisible by 400
     *
     * @param year
     *            the year
     * @return true, if successful
     */
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }
}