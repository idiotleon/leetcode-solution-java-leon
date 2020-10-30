/**
 * https://leetcode.com/problems/insert-interval/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/insert-interval/discuss/21600/Short-java-code
 */
package com.zea7ot.leetcode.lvl4.lc0057;

import java.util.ArrayList;
import java.util.List;

class SolutionApproach0Greedy {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // sanity check
        if (intervals == null || intervals.length == 0)
            return new int[0][2];

        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0])
                ans.add(interval);
            else if (interval[0] > newInterval[1]) {
                ans.add(newInterval);
                ans.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (newInterval != null) {
            ans.add(newInterval);
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}