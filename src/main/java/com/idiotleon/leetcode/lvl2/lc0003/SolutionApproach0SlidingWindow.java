package com.idiotleon.leetcode.lvl2.lc0003;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        final char[] chs = s.toCharArray();
        final int[] freqs = new int[128];

        int lo = 0, hi = 0;
        while (hi < L) {
            ++freqs[chs[hi]];
            while (freqs[chs[hi]] > 1) {
                --freqs[chs[lo]];
                ++lo;
            }

            // please pay attention to the relative position of the two lines right below
            final int len = hi - lo + 1;
            longest = Math.max(longest, len);

            ++hi;
        }

        return longest;
    }
}