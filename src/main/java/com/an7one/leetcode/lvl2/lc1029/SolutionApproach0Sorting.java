/**
 * https://leetcode.com/problems/two-city-scheduling/
 * 
 * Time Complexity:     O(N *lg(N))
 * Space Complexity:    O(1)
 * 
 * to sort the array by "savings", from small to large.
 *  "savings" is how much one can save flying to A v.s. to B
 * 
 * References:
 *  https://leetcode.com/problems/two-city-scheduling/discuss/668155/Two-Approach-or-Detailed-Explanation-or-Clean-Code-or-Java-1ms-or
 */
package com.an7one.leetcode.lvl2.lc1029;

import java.util.Arrays;

public class SolutionApproach0Sorting {
    public int twoCitySchedCost(int[][] costs) {
        // sanity check
        if (costs == null || costs.length == 0)
            return 0;

        final int N = costs.length;
        Arrays.sort(costs, (a, b) -> (a[0] - b[0]) - (a[1] - b[1]));

        int minCost = 0;
        for (int i = 0; i < N / 2; i++) {
            minCost += costs[i][0];
            minCost += costs[N / 2 + i][1];
        }

        return minCost;
    }
}