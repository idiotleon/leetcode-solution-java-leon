/**
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Time Complexity:     O(LEN_HAYSTACK + LEN_NEEDLE) ~ O(max(LEN_HAYSTACK, LEN_NEEDLE))
 * Space Complexity:    O(LEN_NEEDLE)
 */
package com.idiotleon.leetcode.lvl2.lc0028;

public class SolutionApproach0KMPAlgorithm {
    public int strStr(String haystack, String needle) {
        // santiy check
        if (needle == null || needle.isEmpty())
            return 0;

        final int LEN_NEEDLE = needle.length();
        final char[] CHS_NEEDLE = needle.toCharArray();
        final int LEN_HAYSTACK = haystack.length();
        final char[] CHS_HAYSTACK = haystack.toCharArray();

        // sanity check
        if (LEN_HAYSTACK < LEN_NEEDLE)
            return -1;

        final int[] KMP = new int[LEN_NEEDLE];
        int i = 1, j = 0;
        while (i < LEN_NEEDLE) {
            if (CHS_NEEDLE[i] == CHS_NEEDLE[j]) {
                KMP[i++] = ++j;
            } else if (j == 0) {
                KMP[i] = 0;
                ++i;
            } else {
                j = KMP[j - 1];
            }
        }

        i = 0;
        j = 0;
        while (i < LEN_HAYSTACK) {
            if (j == LEN_NEEDLE)
                break;

            if (CHS_HAYSTACK[i] == CHS_NEEDLE[j]) {
                ++i;
                ++j;
            } else if (j == 0) {
                ++i;
            } else {
                j = KMP[j - 1];
            }
        }

        if (j == LEN_NEEDLE)
            return i - LEN_NEEDLE;

        return -1;
    }
}