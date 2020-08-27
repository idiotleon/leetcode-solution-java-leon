/**
 * https://leetcode.com/problems/find-right-interval/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-right-interval/discuss/91789/Java-clear-O(n-logn)-solution-based-on-TreeMap
 */
package com.zea7ot.leetcode.lvl3.lc0436;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0TreeMap {
    public int[] findRightInterval(int[][] intervals) {
        // sanity check
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return new int[0];

        final int N = intervals.length;
        int[] ans = new int[N];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; ++i)
            map.put(intervals[i][0], i);

        for (int i = 0; i < N; ++i) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            ans[i] = (entry == null) ? -1 : entry.getValue();
        }

        return ans;
    }
}