/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl3.lc0056;

import java.util.Arrays;
import java.util.LinkedList;

public class SolutionApproach0Greedy {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<int[]>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}