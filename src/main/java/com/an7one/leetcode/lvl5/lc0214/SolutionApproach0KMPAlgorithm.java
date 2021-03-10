/**
 * https://leetcode.com/problems/shortest-palindrome/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * Analysis: One can use KMP to track the string and match from back to front until two pointers met, 
 * the back position deduct the front position is the characters we want to patch.
 */
package com.an7one.leetcode.lvl5.lc0214;

public class SolutionApproach0KMPAlgorithm {
    public String shortestPalindrome(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return "";

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        final int[] KMP = new int[L];

        int i = 1, j = 0;
        while (i < L) {
            if (CHS[i] == CHS[j]) {
                KMP[i++] = ++j;
            } else if (j == 0) {
                ++i;
            } else {
                j = KMP[j - 1];
            }
        }

        i = 0;
        j = 0;
        while (i + j < L) {
            if (CHS[j] == CHS[L - 1 - i]) {
                ++i;
                ++j;
            } else if (j == 0) {
                ++i;
            } else {
                j = KMP[j - 1];
            }
        }

        StringBuilder builder = new StringBuilder();
        i -= j;
        for (int k = 0; k < i; ++k)
            builder.append(CHS[L - 1 - k]);

        builder.append(s);
        return builder.toString();
    }
}