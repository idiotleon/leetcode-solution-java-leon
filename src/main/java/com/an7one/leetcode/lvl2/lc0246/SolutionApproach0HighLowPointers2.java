/**
 * https://leetcode.com/problems/strobogrammatic-number/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 * 
 * References:
 *  https://leetcode.com/problems/strobogrammatic-number/discuss/67182/Accepted-Java-solution
 */
package com.an7one.leetcode.lvl2.lc0246;

public class SolutionApproach0HighLowPointers2 {
    private static final char[] map = { '0', '1', 'n', 'n', 'n', 'n', '9', 'n', '8', '6' };

    public boolean isStrobogrammatic(String num) {
        // sanity check
        if (num == null || num.isEmpty())
            return false;

        final int L = num.length();
        char[] digits = num.toCharArray();
        int idx = 0;

        while (idx < L) {
            if (map[digits[idx] - '0'] != digits[L - idx - 1])
                return false;

            ++idx;
        }

        return true;
    }
}