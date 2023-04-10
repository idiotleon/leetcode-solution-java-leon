/**
 * https://leetcode.com/problems/meeting-rooms/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0252;

import java.util.Arrays;

public class SolutionApproach0Greedy {
    public boolean canAttendMeetings(int[][] intervals) {
        // sanity check
        if(intervals == null || intervals.length == 0) return true;

        final int N = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for(int i = 1; i < N; i++){
            if(intervals[i][0] < intervals[i - 1][1]){
                return false;
            }
        }
        
        return true;
    }
}