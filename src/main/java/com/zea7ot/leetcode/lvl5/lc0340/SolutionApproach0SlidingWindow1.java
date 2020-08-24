/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl5.lc0340;

public class SolutionApproach0SlidingWindow1 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        final int L = s.length();
        char[] chs = s.toCharArray();
        int[] freq = new int[256];
        int distinct = 0, longest = 0;

        int lo = 0, hi = 0;
        while (hi < L) {
            if (freq[chs[hi++]]++ == 0)
                ++distinct;
            while (distinct > k)
                if (--freq[chs[lo++]] == 0)
                    --distinct;
            longest = Math.max(longest, hi - lo);
        }

        return longest;
    }
}