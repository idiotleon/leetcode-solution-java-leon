package com.an7one.leetcode.lvl3.lc0680;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * <p>
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0HighLowPointers {
    public boolean validPalindrome(String s) {
        final int L = s.length();
        int lo = 0, hi = L - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return isPalindrome(lo, hi - 1, s) || isPalindrome(lo + 1, hi, s);
            }

            ++lo;
            --hi;
        }

        return true;
    }

    private boolean isPalindrome(int lo, int hi, String str) {
        while (lo < hi) {
            if (str.charAt(lo) != str.charAt(hi)) {
                return false;
            }

            ++lo;
            --hi;
        }

        return true;
    }
}