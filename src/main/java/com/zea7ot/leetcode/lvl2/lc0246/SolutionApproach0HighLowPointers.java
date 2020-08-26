/**
 * https://leetcode.com/problems/strobogrammatic-number/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 * 
 * References:
 *  https://leetcode.com/problems/strobogrammatic-number/discuss/67182/Accepted-Java-solution
 */
package com.zea7ot.leetcode.lvl2.lc0246;

public class SolutionApproach0HighLowPointers {
    private static final char[] map = { '0', '1', 'n', 'n', 'n', 'n', '9', 'n', '8', '6' };

    public boolean isStrobogrammatic(String num) {
        // sanity check
        if (num == null || num.isEmpty())
            return false;

        final int L = num.length();
        char[] digits = num.toCharArray();
        int lo = 0, hi = L - 1;

        while (lo <= hi) {
            if (map[digits[lo] - '0'] != digits[hi])
                return false;

            ++lo;
            --hi;
        }

        return true;
    }
}