/**
 * https://leetcode.com/problems/paint-house-ii/
 * 
 * Time Complexity:     O(N * K) ~ O(N * K)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/paint-house-ii/discuss/69492/AC-Java-solution-without-extra-space/71565
 */
package com.zea7ot.leetcode.lvl4.lc0265;

public class SolutionApproach0DP2Dimen {
    public int miKostII(int[][] costs) {
        // sanity check
        if (costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;

        final int N = costs.length, K = costs[0].length;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int jMin1 = -1;
        for (int j = 0; j < K; ++j) {
            if (costs[0][j] < min1) {
                jMin1 = j;
                min2 = min1;
                min1 = costs[0][j];
            } else if (costs[0][j] < min2) {
                min2 = costs[0][j];
            }
        }

        for (int i = 1; i < N; ++i) {
            int last1 = min1, last2 = min2, jLast = jMin1;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;

            for (int j = 0; j < K; ++j) {
                int val = 0;
                if (j != jLast) {
                    val = last1 + costs[i][j];
                } else {
                    val = last2 + costs[i][j];
                }

                if (val < min1) {
                    jMin1 = j;
                    min2 = min1;
                    min1 = val;
                } else if (val < min2) {
                    min2 = val;
                }
            }
        }

        return min1;
    }
}