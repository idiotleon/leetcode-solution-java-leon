/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 * 
 * Time Complexity:     O(N ^ 3)
 * Space Complexity:    O(N ^ 2)
 * 
 * dp[i, j] = dp[i, k] + dp[k + 1, j] + max(nums[i, k]) * max(nums[k + 1, j])
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/340027/Java-DP-easy-to-understand
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/340489/Summary-and-reasoning-of-different-solutions
 */
package com.an7one.leetcode.lvl4.lc1130;

public class SolutionApproach1DP2Dimen {
    public int mctFromLeafValues(int[] nums) {
        final int N = nums.length;
        int[][] dp = new int[N][N];

        for (int level = 2; level <= N; level++) {
            for (int i = 0; i <= N - level; i++) {
                int j = i + level - 1;
                for (int k = i; k < j; k++) {
                    if (dp[i][j] != 0) {
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i][k] + dp[k + 1][j] + (getMax(i, k, nums) * getMax(k + 1, j, nums)));
                    } else {
                        dp[i][j] = dp[i][k] + dp[k + 1][j] + (getMax(i, k, nums) * getMax(k + 1, j, nums));
                    }
                }
            }
        }

        return dp[0][N - 1];
    }

    private int getMax(int lo, int hi, int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int k = lo; k <= hi; ++k) {
            max = Math.max(max, nums[k]);
        }

        return max;
    }
}