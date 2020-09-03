/**
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Time Complexity:     O(max(LEN_NEEDLE, LEN_HAYSTACK))
 * Space Complexity:    O(max(LEN_NEEDLE, LEN_HAYSTACK))
 */
package com.zea7ot.leetcode.lvl2.lc0028;

public class SolutionApproach1TwoPointers {
    public int strStr(String haystack, String needle) {
        // sanity check
        if (needle == null || needle.isEmpty())
            return 0;

        final int LEN_NEEDLE = needle.length();
        final char[] CHS_NEEDLE = needle.toCharArray();
        final int LEN_HAYSTACK = haystack.length();
        final char[] CHS_HAYSTACK = haystack.toCharArray();

        // sanity check
        if (LEN_HAYSTACK < LEN_NEEDLE)
            return -1;

        int idxHaystack = 0;

        while (idxHaystack < LEN_HAYSTACK) {
            int idxNeedle = 0;
            while (idxNeedle < LEN_NEEDLE) {
                if (idxHaystack + idxNeedle == LEN_HAYSTACK)
                    return -1;
                if (CHS_HAYSTACK[idxHaystack + idxNeedle] != CHS_NEEDLE[idxNeedle])
                    break;

                if (++idxNeedle == LEN_NEEDLE)
                    return idxHaystack;
            }

            ++idxHaystack;
            // added on line 29
            // if(++idxHaystack + idxNeedle == LEN_HAYSTACK) return -1;
        }

        return -1;
    }
}