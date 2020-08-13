/**
 * https://leetcode.com/problems/decode-ways-ii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/decode-ways-ii/discuss/105258/Java-O(N)-by-General-Solution-for-all-DP-problems/107909
 *  https://leetcode.com/problems/decode-ways-ii/discuss/105258/Java-O(N)-by-General-Solution-for-all-DP-problems
 */
package com.zea7ot.lc.lvl4.lc0639;

public class SolutionApproach0DP1Dimen {
    private static final int MOD = (int) 1e9 + 7;
    private static final char PLACE_HOLDER = '*';

    public int numDecodings(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        char[] chs = s.toCharArray();
        // sanity check
        if (chs[0] == '0')
            return 0;

        long[] dp = new long[L + 1];
        dp[0] = 1;
        dp[1] = chs[0] == PLACE_HOLDER ? 9 : 1;

        for (int i = 2; i <= L; ++i) {
            char first = chs[i - 2];
            char second = chs[i - 1];
            if (second == PLACE_HOLDER)
                dp[i] += 9 * dp[i - 1];
            else if (second != '0')
                dp[i] += dp[i - 1];

            if (first == PLACE_HOLDER) {
                if (second == PLACE_HOLDER) {
                    dp[i] += 15 * dp[i - 2];
                } else if (second <= '6') {
                    dp[i] += 2 * dp[i - 2];
                } else
                    dp[i] += dp[i - 2];
            } else if (first == '1') {
                if (second == PLACE_HOLDER)
                    dp[i] += 9 * dp[i - 2];
                else
                    dp[i] += dp[i - 2];
            } else if (first == '2') {
                if (second == PLACE_HOLDER)
                    dp[i] += 6 * dp[i - 2];
                else if (second <= '6')
                    dp[i] += dp[i - 2];
            }

            dp[i] %= MOD;
        }

        return (int) dp[L];
    }
}