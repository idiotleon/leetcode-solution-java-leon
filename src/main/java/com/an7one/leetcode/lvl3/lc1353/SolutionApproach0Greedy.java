/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 * 
 * Time Complexity:     O(N * lg(N)) + O(RANGE)
 * Space Complexity:    O(RANGE)
 */
package com.an7one.leetcode.lvl3.lc1353;

import java.util.Arrays;

public class SolutionApproach0Greedy {
    public int maxEvents(int[][] events) {
        // sanity check
        if (events == null || events.length == 0)
            return 0;

        final int RANGE = (int) 1e5 + 1;

        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int max = 0;
        boolean[] seen = new boolean[RANGE];

        for (int[] event : events) {
            int start = event[0], end = event[1];
            for (int i = start; i <= end; ++i) {
                if (seen[i])
                    continue;
                seen[i] = true;
                ++max;
                break;
            }
        }

        return max;
    }
}