/**
 * https://leetcode.com/problems/decode-ways-ii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/decode-ways-ii/discuss/105258/Java-O(N)-by-General-Solution-for-all-DP-problems/649524
 *  https://leetcode.com/problems/decode-ways-ii/discuss/105258/Java-O(N)-by-General-Solution-for-all-DP-problems
 */
package com.zea7ot.leetcode.lvl4.lc0639;

public class SolutionApproach0DP0Dimen1 {
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

        long prev1 = chs[0] == PLACE_HOLDER ? 9 : 1;
        long prev2 = 1;

        for (int i = 1; i < L; ++i) {
            long res = 0;
            char first = chs[i - 1];
            char second = chs[i];
            if (second == PLACE_HOLDER)
                res = 9 * prev1;
            else if (second > '0')
                res = prev1;

            if (first == PLACE_HOLDER) {
                if (second == PLACE_HOLDER)
                    res += 15 * prev2;
                else if (second <= '6')
                    res += 2 * prev2;
                else
                    res += prev2;
            } else if (first == '1' || first == '2') {
                if (second == PLACE_HOLDER)
                    res += first == '1' ? 9 * prev2 : 6 * prev2;
                else if (second <= '6')
                    res += prev2;
                else if (first == '1')
                    res += prev2;
            }

            res %= MOD;
            prev2 = prev1;
            prev1 = res;
        }

        return (int) prev1;
    }
}