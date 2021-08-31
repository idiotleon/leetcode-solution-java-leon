package com.an7one.leetcode.lvl1.lc0058;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * <p>
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(`L`) / O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0LinearScan {
    private static final char SPACE = ' ';

    public int lengthOfLastWord(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        int hi = L - 1;

        while (hi >= 0 && CHS[hi] == SPACE) {
            --hi;
        }

        int len = 0;
        while (hi >= 0 && CHS[hi] != SPACE) {
            --hi;
            ++len;
        }

        return len;
    }
}
