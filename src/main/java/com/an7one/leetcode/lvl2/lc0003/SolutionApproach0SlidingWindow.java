/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0003;

public class SolutionApproach0SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        final int[] FREQS = new int[128];

        int lo = 0, hi = 0;
        while (hi < L) {
            ++FREQS[CHS[hi]];
            while (FREQS[CHS[hi]] > 1) {
                --FREQS[CHS[lo]];
                ++lo;
            }

            // please pay attention to the relative position of the two lines right below
            final int LEN = hi - lo + 1;
            longest = Math.max(longest, LEN);

            ++hi;
        }

        return longest;
    }
}