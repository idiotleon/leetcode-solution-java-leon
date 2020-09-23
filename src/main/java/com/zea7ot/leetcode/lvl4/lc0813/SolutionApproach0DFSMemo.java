/**
 * https://leetcode.com/problems/largest-sum-of-averages/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/largest-sum-of-averages/discuss/122739/C%2B%2BJavaPython-Easy-Understood-Solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc0813;

public class SolutionApproach0DFSMemo {
    public double largestSumOfAverages(int[] nums, int K) {
        final int N = nums.length;
        double[][] memo = new double[N + 1][N + 1];
        double sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += nums[i];
            memo[i + 1][1] = sum / (i + 1);
        }

        return dfs(N, K, nums, memo);
    }

    private double dfs(int len, int k, int[] nums, double[][] memo) {
        if (memo[len][k] > 0)
            return memo[len][k];
        if (len < k)
            return 0;
        double sum = 0;
        for (int i = len - 1; i > 0; --i) {
            sum += nums[i];
            memo[len][k] = Math.max(memo[len][k], dfs(i, k - 1, nums, memo) + sum / (len - i));
        }
        return memo[len][k];
    }
}