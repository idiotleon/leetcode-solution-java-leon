package com.an7one.leetcode.lvl2.lc0003;


import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * <p>
 * please be cautious that the `s` not just contains lower case letters
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow1 {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        final char[] chs = s.toCharArray();
        final int[] lastIndices = new int[128];

        int lo = 0, hi = 0;
        while (hi < L) {
            lo = Math.max(lo, lastIndices[chs[hi]]);
            longest = Math.max(longest, hi - lo + 1);
            lastIndices[chs[hi]] = hi + 1;

            ++hi;
        }

        return longest;
    }
}