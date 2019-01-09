package com.semaphone.utils;

/**
 * The Class Date.
 */
public class Date {
    
    /** The day. */
    private int day;
    
    /** The month. */
    private int month;
    
    /** The year. */
    private int year;

    /**
     * Instantiates a new date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        
    }

    /**
     * Gets the day.
     *
     * @return the day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Gets the month.
     *
     * @return the month
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Gets the year.
     *
     * @return the year
     */
    public int getYear() {
        return this.year;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Date other = (Date) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return year+"-" + month + "-" + day;
    }
    
    
}