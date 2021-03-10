/**
 * https://leetcode.com/problems/paint-house/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/paint-house/discuss/68211/Simple-java-DP-solution
 */
package com.an7one.leetcode.lvl3.lc0256;

public class SolutionAppraoch0DP0Dimen {
    public int minCost(int[][] costs) {
        // sanity check
        if (costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;

        int color0 = 0, color1 = 0, color2 = 0;
        for (int[] cost : costs) {
            final int PREV_COLOR0 = color0;
            final int PREV_COLOR1 = color1;
            final int PREV_COLOR2 = color2;

            color0 = cost[0] + Math.min(PREV_COLOR1, PREV_COLOR2);
            color1 = cost[1] + Math.min(PREV_COLOR0, PREV_COLOR2);
            color2 = cost[2] + Math.min(PREV_COLOR0, PREV_COLOR1);
        }

        return Math.min(color0, Math.min(color1, color2));
    }
}