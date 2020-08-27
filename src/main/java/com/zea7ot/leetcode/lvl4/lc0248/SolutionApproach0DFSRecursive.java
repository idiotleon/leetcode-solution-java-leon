/**
 * https://leetcode.com/problems/strobogrammatic-number-iii/
 * 
 * Time Complexity:     O()
 * Space Complexiyt:    O()
 * 
 * References:
 *  https://leetcode.com/problems/strobogrammatic-number-iii/discuss/67378/Concise-Java-Solution/69269
 *  https://leetcode.com/problems/strobogrammatic-number-iii/discuss/67378/Concise-Java-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0248;

public class SolutionApproach0DFSRecursive {
    private static final char[][] PAIRS = new char[][] { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' },
            { '9', '6' } };

    public int strobogrammaticInRange(String low, String high) {
        // sanity check
        if (low == null || high == null || low.length() > high.length()
                || (low.length() == high.length() && low.compareTo(high) > 0))
            return 0;

        final int LEN_LOW = low.length(), LEN_HIGH = high.length();
        int count = 0;
        for (int len = LEN_LOW; len <= LEN_HIGH; ++len)
            count += dfs(0, len - 1, new char[len], low, high);

        return count;
    }

    private int dfs(int lo, int hi, final char[] CHS, final String LOW, final String HIGH) {
        if (lo > hi) {
            String str = new String(CHS);
            if ((CHS.length == LOW.length() && str.compareTo(LOW) < 0)
                    || (CHS.length == HIGH.length() && str.compareTo(HIGH) > 0))
                return 0;
            else
                return 1;
        }

        int count = 0;
        for (final char[] PAIR : PAIRS) {
            CHS[lo] = PAIR[0];
            CHS[hi] = PAIR[1];

            if (CHS.length != 1 && CHS[0] == '0')
                continue;

            if (lo == hi && (PAIR[0] == '6' || PAIR[0] == '9'))
                continue;

            count += dfs(lo + 1, hi - 1, CHS, LOW, HIGH);
        }

        return count;
    }
}