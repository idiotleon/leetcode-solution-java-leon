/**
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Time Complexity:     O(max(LEN_NEEDLE, LEN_HAYSTACK))
 * Space Complexity:    O(max(LEN_NEEDLE, LEN_HAYSTACK))
 */
package com.an7one.leetcode.lvl2.lc0028;

public class SolutionApproach1TwoPointers1 {
    public int strStr(String haystack, String needle) {
        final int LEN_NEEDLE = needle.length();
        final int LEN_HAYSTACK = haystack.length();

        // sanity check
        if (LEN_HAYSTACK < LEN_NEEDLE)
            return -1;

        for (int i = 0;; ++i) {
            for (int j = 0;; ++j) {
                if (j == LEN_NEEDLE)
                    return i;
                if (i + j == LEN_HAYSTACK)
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }
}