package com.idiotleon.leetcode.lvl3.lc0340;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * Reference:
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/discuss/80047/15-lines-java-solution-using-slide-window
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow1 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        final int L = s.length();
        char[] chs = s.toCharArray();
        int[] freqs = new int[256];
        int distinct = 0, longest = 0;

        int lo = 0, hi = 0;
        while (hi < L) {
            if (freqs[chs[hi++]]++ == 0)
                ++distinct;

            while (distinct > k) {
                if (--freqs[chs[lo++]] == 0)
                    --distinct;
            }

            longest = Math.max(longest, hi - lo);
        }

        return longest;
    }
}