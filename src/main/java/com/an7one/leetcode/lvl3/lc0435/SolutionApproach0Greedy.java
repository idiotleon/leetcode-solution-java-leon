/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
 */
package com.an7one.leetcode.lvl3.lc0435;

import java.util.Arrays;

public class SolutionApproach0Greedy {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sanity check
        if (intervals == null || intervals.length == 0)
            return 0;

        final int N = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
                ++count;
            }
        }

        return N - count;
    }
}