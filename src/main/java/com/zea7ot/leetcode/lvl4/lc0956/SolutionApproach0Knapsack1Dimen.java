/**
 * https://leetcode.com/problems/tallest-billboard/
 * 
 * Time Complexity:     O(N * sum)
 * Space Complexity:    O(sum)
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-956-tallest-billboard/
 *  https://www.youtube.com/watch?v=iPRWkifQgoo
 *  https://www.youtube.com/watch?v=WqLslW2sFxU
 */
package com.zea7ot.leetcode.lvl4.lc0956;

import java.util.Arrays;

public class SolutionApproach0Knapsack1Dimen {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int rod : rods)
            sum += rod;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int rod : rods) {
            int[] cur = dp.clone();
            for (int i = 0; i <= sum - rod; ++i) {
                if (cur[i] < 0)
                    continue;
                dp[i + rod] = Math.max(dp[i + rod], cur[i]);
                dp[Math.abs(i - rod)] = Math.max(dp[Math.abs(i - rod)], cur[i] + Math.min(rod, i));
            }
        }

        return dp[0];
    }
}