/**
 * https://leetcode.com/problems/palindrome-removal/
 * 
 * Time Complexity:     O(N * N * N)
 * Space Complexity:    O(N * N)
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-removal/discuss/418835/JavaC%2B%2BPython3-DP-with-Details-Comments
 *  https://www.geeksforgeeks.org/minimum-steps-to-delete-a-string-after-repeated-deletion-of-palindrome-substrings/
 *  https://youtu.be/FLbqgyJ-70I?t=7635
 */
package com.zea7ot.leetcode.lvl4.lc1246;

public class SolutionApproach0DP2Dimen {
    public int minimumMoves(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[][] dp = new int[N + 1][N + 1];

        for (int len = 1; len <= N; ++len) {
            for (int i = 0, j = len - 1; j < N; ++i, ++j) {
                if (len == 1)
                    dp[i][j] = 1;
                else {
                    // to delete `nums[i]` individually and assign the result for the subproblem s[i
                    // + 1 : j]
                    dp[i][j] = 1 + dp[i + 1][j];

                    if (nums[i] == nums[i + 1])
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 2][j]);

                    for (int k = i + 2; k <= j; ++k) {
                        if (nums[i] == nums[k])
                            dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][N - 1];
    }
}