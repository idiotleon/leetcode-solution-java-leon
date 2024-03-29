package com.idiotleon.leetcode.lvl4.lc0395;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/">description</a>
 *
 * Time Complexity:     O(26 * 26 * L) ~ O(L)
 * Space Complexity:    O(1) / O(L) + O(26) ~ O(1) / O(L)
 *
 * References:
 *  <a href="https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87739/Java-Strict-O(N)-Two-Pointer-Solution/188126">...</a>
 *  <a href="https://www.cnblogs.com/grandyang/p/5852352.html">...</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow {
    public int longestSubstring(String s, int k) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        if (k < 2)
            return L;

        final char[] CHS = s.toCharArray();

        for (int allowed = 1; allowed <= 26; ++allowed) {
            final int[] freqs = new int[26];

            int lo = 0, hi = 0;
            int distinct = 0;

            while (hi < L) {
                if (freqs[CHS[hi] - 'a']++ == 0)
                    ++distinct;

                while (distinct > allowed) {
                    if (--freqs[CHS[lo] - 'a'] == 0)
                        --distinct;

                    ++lo;
                }

                if (isValid(k, freqs))
                    longest = Math.max(longest, hi - lo + 1);

                ++hi;
            }
        }

        return longest;
    }

    private boolean isValid(final int K, final int[] FREQS) {
        for (int freq : FREQS) {
            if (freq > 0 && freq < K)
                return false;
        }

        return true;
    }
}