package com.idiotleon.leetcode.lvl1.lc0058;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
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
        final char[] chs = s.toCharArray();
        int hi = L - 1;

        while (hi >= 0 && chs[hi] == SPACE) {
            --hi;
        }

        int len = 0;
        while (hi >= 0 && chs[hi] != SPACE) {
            --hi;
            ++len;
        }

        return len;
    }
}
