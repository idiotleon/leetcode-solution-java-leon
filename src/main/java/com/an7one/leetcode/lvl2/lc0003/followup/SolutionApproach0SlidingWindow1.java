package com.an7one.leetcode.lvl2.lc0003.followup;

import com.an7one.util.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * how about `k` repeated characters being allowed?
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow1 {
    public int lengthOfLongestSubstring(String s, int k) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        final char[] chs = s.toCharArray();
        final Map<Character, Integer> freqs = new HashMap<>();
        int lo = 0, hi = 0;
        int threshold = 0;

        while (hi < L) {
            freqs.put(chs[hi], freqs.getOrDefault(chs[hi], 0) + 1);
            if (freqs.get(chs[hi]) > 1)
                ++threshold;

            while (threshold > 0) {
                if (freqs.get(chs[lo]) > k)
                    --threshold;

                freqs.put(chs[lo], freqs.get(chs[lo]) - 1);
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}