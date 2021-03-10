/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * how about k repeated characters being allowed?
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0003.followup;

public class SolutionApproach0SlidingWindow {
    public int lengthOfLongestSubstring(String s, int k) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        final int[] FREQS = new int[256];

        int lo = 0, hi = 0;
        int threshold = 0;

        while (hi < L) {
            ++FREQS[CHS[hi]];
            if (FREQS[CHS[hi]] > 1) {
                ++threshold;
            }

            while (threshold > 0) {
                if (FREQS[CHS[lo]] > k) {
                    --threshold;
                }
                --FREQS[CHS[lo]];
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}