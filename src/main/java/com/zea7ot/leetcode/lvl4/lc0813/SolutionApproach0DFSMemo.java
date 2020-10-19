/**
 * https://leetcode.com/problems/largest-sum-of-averages/
 * 
 * Time Complexity:     O(`K` * (`N` ^ 2))
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/largest-sum-of-averages/discuss/122739/C%2B%2BJavaPython-Easy-Understood-Solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc0813;

public class SolutionApproach0DFSMemo {
    public double largestSumOfAverages(int[] nums, int K) {
        final int N = nums.length;

        double[][] memo = new double[N + 1][K + 1];
        double sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += nums[i];
            memo[i + 1][1] = sum / (i + 1);
        }

        return dfs(N, K, nums, memo);
    }

    private double dfs(final int N, final int K, int[] nums, double[][] memo) {
        if (memo[N][K] > 0)
            return memo[N][K];

        if (N < K)
            return 0;

        double sum = 0;
        for (int i = N - 1; i > 0; --i) {
            sum += nums[i];
            memo[N][K] = Math.max(memo[N][K], dfs(i, K - 1, nums, memo) + sum / (N - i));
        }

        return memo[N][K];
    }
}