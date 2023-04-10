/**
 * https://leetcode.com/problems/paint-house/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/paint-house/discuss/68211/Simple-java-DP-solution/226382
 */
package com.idiotleon.leetcode.lvl3.lc0256;

public class SolutionApproach0DP0Dimen2 {
    public int minCost(int[][] costs) {
        // sanity check
        if (costs == null || costs.length == 0)
            return 0;

        final int N = costs.length;
        int[] prev = new int[3];
        for (int col = 0; col < 3; col++)
            prev[col] = costs[0][col];
        int[] cur = new int[3];

        for (int i = 1; i < N; i++) {
            cur[0] = costs[i][0] + Math.min(prev[1], prev[2]);
            cur[1] = costs[i][1] + Math.min(prev[0], prev[2]);
            cur[2] = costs[i][2] + Math.min(prev[0], prev[1]);

            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }
}