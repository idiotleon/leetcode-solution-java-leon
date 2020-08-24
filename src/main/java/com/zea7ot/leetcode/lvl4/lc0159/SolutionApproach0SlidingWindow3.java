/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 */
package com.zea7ot.leetcode.lvl4.lc0159;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow3 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        char[] chs = s.toCharArray();

        Map<Character, Integer> freq = new HashMap<>();
        int lo = 0, hi = 0;
        int longest = 0;
        int distinct = 0;

        while (hi < L) {
            freq.put(chs[hi], freq.getOrDefault(chs[hi], 0) + 1);
            if (freq.get(chs[hi]) == 1)
                ++distinct;

            while (distinct > 2) {
                if (freq.put(chs[lo], freq.get(chs[lo]) - 1) == 0)
                    --distinct;
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}