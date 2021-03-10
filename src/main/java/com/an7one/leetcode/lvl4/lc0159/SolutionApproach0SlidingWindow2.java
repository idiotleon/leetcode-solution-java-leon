/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(2) + O(1) / O(L) ~ O(1) / O(L)
 */
package com.an7one.leetcode.lvl4.lc0159;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow2 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        char[] chs = s.toCharArray();

        Map<Character, Integer> freq = new HashMap<>();
        int lo = 0, hi = 0;
        int longest = 0;

        while (hi < L) {
            freq.put(chs[hi], freq.getOrDefault(chs[hi], 0) + 1);

            while (freq.size() > 2) {
                if (freq.put(chs[lo], freq.get(chs[lo]) - 1) == 1)
                    freq.remove(chs[lo]);

                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}