/**
 * https://leetcode.com/problems/delete-and-earn/
 * 
 * Time Complexity:     O(N + `RANGE`) + O(`RANGE`) ~ O(N + `RANGE`)
 *  N, the Number of elements in the input array
 *  R, the Range of the value of each integer element, which, in this case, is 10001,
 *      and can be optimized to the max value in the array, at an extra cost of O(N)
 * 
 * Space Complexity:    O(N + `RANGE`)
 * 
 * References:
 *  https://leetcode.com/problems/delete-and-earn/discuss/109889/Java-Easy-DP-Solution/111623
 *  https://www.youtube.com/watch?v=YzZd-bsMthk
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-740-delete-and-earn/
 */
package com.an7one.leetcode.lvl4.lc0740;

public class SolutionApproach0DP1Dimen {
    public int deleteAndEarn(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int RANGE = (int) 1e4 + 1;
        int[] sums = new int[RANGE];

        for (int num : nums) {
            sums[num] += num;
        }

        int[] dp = new int[RANGE];
        dp[1] = sums[1];
        for (int i = 2; i < RANGE; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sums[i]);
        }

        return dp[RANGE - 1];
    }
}