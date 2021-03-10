/**
 * https://leetcode.com/problems/path-sum-iv/
 * 
 * Time Complexity:     O(40) ~ O(1)
 * Space Complexity:    O(40) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/path-sum-iv/discuss/106887/C%2B%2B-Java-Clean-Code
 */
package com.an7one.leetcode.lvl3.lc0666;

public class SolutionApproach0DP0Dimen {
    public int pathSum(int[] nums) {
        int[][] dp = new int[5][8];
        for (int num : nums) {
            int i = num / 100;
            int j = (num % 100) / 10 - 1;
            int v = num % 10;
            dp[i][j] = dp[i - 1][j / 2] + v;
        }

        int sum = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 4 || dp[i][j] != 0 && dp[i + 1][j * 2] == 0 && dp[i + 1][j * 2 + 1] == 0)
                    sum += dp[i][j];
            }
        }

        return sum;
    }
}