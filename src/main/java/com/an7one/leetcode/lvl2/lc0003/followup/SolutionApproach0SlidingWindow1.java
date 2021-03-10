/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * how about `k` repeated characters being allowed?
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0003.followup;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow1 {
    public int lengthOfLongestSubstring(String s, int k) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        final Map<Character, Integer> FREQS = new HashMap<>();
        int lo = 0, hi = 0;
        int threshold = 0;

        while (hi < L) {
            FREQS.put(CHS[hi], FREQS.getOrDefault(CHS[hi], 0) + 1);
            if (FREQS.get(CHS[hi]) > 1) {
                ++threshold;
            }

            while (threshold > 0) {
                if (FREQS.get(CHS[lo]) > k)
                    --threshold;

                FREQS.put(CHS[lo], FREQS.get(CHS[lo]) - 1);
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}