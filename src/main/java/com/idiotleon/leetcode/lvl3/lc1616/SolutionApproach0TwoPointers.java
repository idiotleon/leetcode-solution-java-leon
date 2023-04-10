package com.idiotleon.leetcode.lvl3.lc1616;

public class SolutionApproach0TwoPointers {
    public boolean checkPalindromeFormation(String a, String b) {
        return checkPalindrome(a, b) || checkPalindrome(b, a);
    }

    private boolean checkPalindrome(String str1, String str2) {
        final int LEN_S = str1.length();

        int lo = 0, hi = LEN_S - 1;

        while (lo < hi) {
            if (str1.charAt(lo) != str2.charAt(hi)) {
                return isPalindrome(lo, hi, str1) || isPalindrome(lo, hi, str2);
            }

            ++lo;
            --hi;
        }

        return true;
    }

    private boolean isPalindrome(int lo, int hi, String str) {
        while (lo < hi) {
            if (str.charAt(lo++) != str.charAt(hi--))
                return false;
        }

        return true;
    }
}
