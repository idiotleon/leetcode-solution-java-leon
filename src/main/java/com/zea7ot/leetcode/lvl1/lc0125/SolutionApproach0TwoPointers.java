/**
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 */
package com.zea7ot.leetcode.lvl1.lc0125;

public class SolutionApproach0TwoPointers {
    public boolean isPalindrome(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return true;
        final int L = s.length();
        char[] chs = s.toCharArray();
        int lo = 0, hi = L - 1;
        while (lo < hi) {
            while (!isAlphanumeric(chs[lo])) {
                ++lo;
                if (lo == L)
                    return true;
            }

            while (!isAlphanumeric(chs[hi]))
                --hi;

            if (Character.toLowerCase(chs[lo++]) != Character.toLowerCase(chs[hi--]))
                return false;
        }

        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}