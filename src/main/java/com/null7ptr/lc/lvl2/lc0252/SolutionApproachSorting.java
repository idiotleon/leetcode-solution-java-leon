/**
 * https://leetcode.com/problems/meeting-rooms/
 */
package com.null7ptr.lc.lvl2.lc0252;

import java.util.Arrays;

public class SolutionApproachSorting {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i - 1][1]){
                return false;
            }
        }
        
        return true;
    }
}