/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * how about `k` repeating characters being allowed?
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0003.followup;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow1 {
    public int lengthOfLongestSubstring(String s, int k) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        int lo = 0, hi = 0, threshold = 0;

        while (hi < L) {
            char ch = s.charAt(hi);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            if (freq.get(ch) > 1)
                ++threshold;

            while (threshold > 0) {
                char temp = s.charAt(lo);
                if (freq.get(temp) > k)
                    threshold--;

                freq.put(temp, freq.get(temp) - 1);
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}