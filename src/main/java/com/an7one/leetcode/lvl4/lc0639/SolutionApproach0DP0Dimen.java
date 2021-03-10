/**
 * https://leetcode.com/problems/decode-ways-ii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * 15 is the number of combinations when both characters are '*'
 * 
 * References:
 *  https://leetcode.com/problems/decode-ways-ii/discuss/105275/Java-DP-O(n)-time-and-O(1)-space
 */
package com.an7one.leetcode.lvl4.lc0639;

public class SolutionApproach0DP0Dimen {
    private static final int MOD = (int) 1e9 + 7;
    private static final char PLACE_HOLDER = '*';

    public int numDecodings(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        char[] chs = s.toCharArray();

        long[] res = new long[2];
        res[0] = decodeWays(chs[0]);
        // sanity check
        if (L < 2)
            return (int) res[0];

        res[1] = res[0] * decodeWays(chs[1]) + decodeWays(chs[0], chs[1]);

        for (int i = 2; i < L; ++i) {
            long temp = res[1];
            res[1] = (res[1] * decodeWays(chs[i]) + res[0] * decodeWays(chs[i - 1], chs[i])) % MOD;
            res[0] = temp;
        }

        return (int) res[1];
    }

    private int decodeWays(char ch1, char ch2) {
        String str = "" + ch1 + ch2;

        if (ch1 != PLACE_HOLDER && ch2 != PLACE_HOLDER) {
            int num = Integer.parseInt(str);
            if (num >= 10 && num <= 26)
                return 1;
        } else if (ch1 == PLACE_HOLDER && ch2 == PLACE_HOLDER)
            return 15;
        else if (ch1 == PLACE_HOLDER) {
            int num = Character.getNumericValue(ch2);
            if (num >= 0 && num <= 6)
                return 2;
            else
                return 1;
        } else {
            int num = Character.getNumericValue(ch1);
            if (num == 1)
                return 9;
            else if (num == 2)
                return 6;
        }

        return 0;
    }

    private int decodeWays(char ch) {
        if (ch == PLACE_HOLDER)
            return 9;
        if (ch == '0')
            return 0;
        return 1;
    }
}