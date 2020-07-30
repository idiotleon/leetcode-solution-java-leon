/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
 */
package com.zea7ot.lc.lvl3.lc0435;

import java.util.Arrays;

public class SolutionApproach0Sorting {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        final int N = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 1;
        int end = intervals[0][1];
        
        for(int i = 1; i < N; ++i){
            if(intervals[i][0] >= end){
                end = intervals[i][1];
                ++count;
            }
        }
        
        return N - count;
    }
}