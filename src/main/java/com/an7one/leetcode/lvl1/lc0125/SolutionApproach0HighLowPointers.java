package com.an7one.leetcode.lvl1.lc0125;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/valid-palindrome/">LC0125</a>
 * <p>
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(1) / O(`L`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0HighLowPointers {
    public boolean isPalindrome(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return true;
        final int L = s.length();
        final char[] chs = s.toCharArray();
        int lo = 0, hi = L - 1;
        while (lo < hi) {
            while (!isAlphanumeric(chs[lo])) {
                ++lo;
                if (lo == L)
                    return true;
            }

            while (!isAlphanumeric(chs[hi])) {
                --hi;
            }

            if (Character.toLowerCase(chs[lo++]) != Character.toLowerCase(chs[hi--]))
                return false;
        }

        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}