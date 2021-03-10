/**
 * https://leetcode.com/problems/fruit-into-baskets/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(128) ~ O(1)
 */
package com.an7one.leetcode.lvl4.lc0159;

public class SolutionApproach0SlidingWindow {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        char[] chs = s.toCharArray();

        int[] freq = new int[128];
        int lo = 0, hi = 0;
        int longest = 0;
        int distinct = 0;
        
        while (hi < L) {
            if (freq[chs[hi]]++ == 0)
                ++distinct;

            while (distinct > 2) {
                if (freq[chs[lo]]-- == 1)
                    --distinct;

                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}