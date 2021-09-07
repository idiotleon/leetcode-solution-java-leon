package com.an7one.leetcode.lvl2.lc0003.followup;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * how about k repeated characters being allowed?
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow {
    public int lengthOfLongestSubstring(String s, int k) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        final char[] chs = s.toCharArray();
        final int[] freqs = new int[256];

        int lo = 0, hi = 0;
        int threshold = 0;

        while (hi < L) {
            ++freqs[chs[hi]];
            if (freqs[chs[hi]] > 1) {
                ++threshold;
            }

            while (threshold > 0) {
                if (freqs[chs[lo]] > k) {
                    --threshold;
                }
                --freqs[chs[lo]];
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}