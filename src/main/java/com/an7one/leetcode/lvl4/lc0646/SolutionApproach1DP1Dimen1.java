/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105602/easy-dp/155950
 */
package com.an7one.leetcode.lvl4.lc0646;

import java.util.Arrays;

public class SolutionApproach1DP1Dimen1 {
    public int findLongestChain(int[][] pairs) {
        // sanity check
        if (pairs == null || pairs.length < 2)
            return 0;

        final int N = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int hi = 0; hi < N; ++hi) {
            for (int lo = 0; lo < hi; ++lo) {
                if (pairs[lo][1] < pairs[hi][0]) {
                    dp[hi] = Math.max(dp[hi], dp[lo] + 1);
                }
            }
        }

        return dp[N - 1];
    }
}