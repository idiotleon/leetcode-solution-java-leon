/**
 * https://leetcode.com/problems/paint-house-ii/
 * 
 * Time Complexity:     O(NR * NC) ~ O(N * k)
 * Space Complexity:    O(1)
 * 
 * `min1` is the index of the smallest cost till the previous house
 * `min2` is the index of the 2nd smallest cost till the previous house
 * 
 * References:
 *  https://leetcode.com/problems/paint-house-ii/discuss/69492/AC-Java-solution-without-extra-space
 */
package com.zea7ot.leetcode.lvl4.lc0265;

public class SolutionApproach0DP2Dimen1 {
    public int minCostII(int[][] costs) {
        // sanity check
        if (costs == null || costs.length == 0)
            return 0;

        final int NR = costs.length, NC = costs[0].length;
        int min1 = -1, min2 = -2;

        for (int row = 0; row < NR; ++row) {
            int last1 = min1, last2 = min2;
            min1 = -1;
            min2 = -1;

            for (int col = 0; col < NC; ++col) {
                if (col != last1) {
                    costs[row][col] += last1 < 0 ? 0 : costs[row - 1][last1];
                } else {
                    costs[row][col] += last2 < 0 ? 0 : costs[row - 1][last2];
                }

                if (min1 < 0 || costs[row][col] < costs[row][min1]) {
                    min2 = min1;
                    min1 = col;
                } else if (min2 < 0 || costs[row][col] < costs[row][min2]) {
                    min2 = col;
                }
            }
        }

        return costs[NR - 1][min1];
    }
}