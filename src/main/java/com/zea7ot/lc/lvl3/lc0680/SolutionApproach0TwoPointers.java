/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0680;

public class SolutionApproach0TwoPointers {
    public boolean validPalindrome(String s) {
        final int L = s.length();
        int lo = -1, hi = L - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return isPalindrome(lo, hi + 1, s) || isPalindrome(lo - 1, hi, s);
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