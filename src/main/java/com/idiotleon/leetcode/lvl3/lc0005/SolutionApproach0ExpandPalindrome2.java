package com.idiotleon.leetcode.lvl3.lc0005;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">LC0005</a>
 * <p>
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution/3700">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0ExpandPalindrome2 {
    public String longestPalindrome(String str) {
        // sanity check
        if (str == null || str.length() < 2) {
            return str;
        }

        final int L = str.length();

        String longest = "";
        for (int i = 0; i < L; ++i) {
            final String str1 = expand(i, i, str);
            final String str2 = expand(i, i + 1, str);

            if (str1.length() > longest.length()) {
                longest = str1;
            }

            if (str2.length() > longest.length()) {
                longest = str2;
            }
        }

        return longest;
    }

    private String expand(int lo, int hi, String str) {
        final int L = str.length();
        while (lo >= 0 && hi < L) {
            if (str.charAt(lo) != str.charAt(hi)) {
                break;
            }
            --lo;
            ++hi;
        }

        return str.substring(lo + 1, hi);
    }
}