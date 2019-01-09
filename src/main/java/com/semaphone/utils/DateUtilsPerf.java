package com.semaphone.utils;

/**
 * The Class DateUtils.
 */
public class DateUtilsPerf {
    
    /** The Constant daysInMonth. */
    private static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    /** The Constant STANDARD_DAYS_IN_YEAR. */
    private static final int STANDARD_DAYS_IN_YEAR = 365;

    /**
     * Adds the days.
     *
     * @param date the date
     * @param amount the amount
     * @return the date
     */
    public static Date addDays(final Date date, final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Days to be added should be zero or more");
        }
        return resolvingYearCalculation(date, amount);
    }

    /**
     * Resolving year calculation.
     * For amount of days which exceeds a year, we resolve the count of year first.
     *
     * @param date the date
     * @param amount the amount
     * @return the date
     */
    private static Date resolvingYearCalculation(final Date date, final int amount) {
        int days = date.getDay() + amount;
        int month = date.getMonth();
        int year = date.getYear();
        
        // We calculate the year and days if number of days supplied is more than a year or more
        if (days >= STANDARD_DAYS_IN_YEAR) {
            int numberOfYears = days / STANDARD_DAYS_IN_YEAR;
            int countOfLeapDays = getLeapDays(days, year, month, numberOfYears);
            year += numberOfYears;
            days = days - countOfLeapDays - (numberOfYears * STANDARD_DAYS_IN_YEAR);
        }
        
        if(days == 0) {
            days = STANDARD_DAYS_IN_YEAR+1;
            year--;
        }
        
        // We then pass it on to add days by month as each month may have different number of days.
        // TODO Note this can be further optimized
        // We can identify quarters or semester where number of day remain constant.
       // For now doing simple addition by month
        return addDaysByMonth(days, month, year);
    }

    /**
     * Adds the days by month.
     *
     * @param days the days
     * @param month the month
     * @param year the year
     * @return the date
     */
    private static Date addDaysByMonth(int days, int month, int year) {
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
        return addDaysByMonth(days, month, year);
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
    
    /**
     * Gets the leap days.
     *
     * @param year the year
     * @param month the month
     * @param numberOfAddedYears the number of added years
     * @return the leap days
     */
    private static int getLeapDays(int days, int year, int month, int numberOfAddedYears) {
        int leapDays = 0;
        for (int i = 0; i <= numberOfAddedYears; i++) {
            if (isLeapYear(year + i)) {
                leapDays++;
            }
        }
        
        // We need to take care of a problem of whether 29 Feb is in range,
        // We can have dates on a leap year but calculation not tipping over 29 Feb, would then be wrong
        //TODO
        
        
        
        

        return leapDays;
    }
}