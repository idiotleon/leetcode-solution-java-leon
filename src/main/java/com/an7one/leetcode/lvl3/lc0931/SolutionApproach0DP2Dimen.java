/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * 
 * Time Complexity:     O(`N` * `N`)
 * Space Complexity:    O(1) / O(`N` * `N`)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-falling-path-sum/discuss/186666/C%2B%2BJava-4-lines-DP
 */
package com.an7one.leetcode.lvl3.lc0931;

public class SolutionApproach0DP2Dimen {
    public int minFallingPathSum(int[][] nums) {
        // sanity check
        if (nums == null || nums.length == 0 || nums[0].length == 0)
            return 0;

        // because it is a square
        final int N = nums.length;

        for (int row = 1; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                nums[row][col] += Math.min(nums[row - 1][Math.max(0, col - 1)],
                        Math.min(nums[row - 1][col], nums[row - 1][Math.min(N - 1, col + 1)]));
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int sum : nums[N - 1]) {
            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }
}