/**
 * @author: Leon
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Time Complexity:     O(LEN_NEEDLE * LEN_HAYSTACK)
 * Space Complexity:    O(max(LEN_NEEDLE, LEN_HAYSTACK))
 */
package com.idiotleon.leetcode.lvl2.lc0028;

public class SolutionApproach2ThreePointers {
    public int strStr(String haystack, String needle) {
        // sanity check
        if (needle == null || needle.isEmpty())
            return 0;

        final int LEN_NEEDLE = needle.length();
        final char[] CHS_NEEDLE = needle.toCharArray();
        final int LEN_HAYSTACK = haystack.length();
        final char[] CHS_HAYSTACK = haystack.toCharArray();

        if (LEN_HAYSTACK < LEN_NEEDLE)
            return -1;

        int idxNeedle = 0, idxHaystack = 0;
        while (idxHaystack < LEN_HAYSTACK) {
            int idx = idxHaystack;
            while (idx < LEN_HAYSTACK && CHS_NEEDLE[idxNeedle] == CHS_HAYSTACK[idx]) {
                ++idx;
                if (++idxNeedle == LEN_NEEDLE)
                    return idx - LEN_NEEDLE;
            }

            idxNeedle = 0;
            ++idxHaystack;
        }

        return -1;
    }
}
