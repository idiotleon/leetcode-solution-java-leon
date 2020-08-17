/**
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 */
package com.zea7ot.leetcode.lvl3.lc1360;

public class SolutionApproach0Since1971 {
    final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysSince1971(date1) - daysSince1971(date2));
    }
    
    private int daysSince1971(String date){
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        
        for(int i = 1971; i < year; i++){
            day += isLeapYear(i) ? 366 : 365;
        }
        
        if(month > 2) day += isLeapYear(year) ? 1 : 0;
        
        for(int i = 1; i < month; i++) day += DAYS_IN_MONTH[i];
        
        return day;
    }
    
    
    private boolean isLeapYear(int year){
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}