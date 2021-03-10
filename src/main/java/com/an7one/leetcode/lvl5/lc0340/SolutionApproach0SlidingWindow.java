/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl5.lc0340;

public class SolutionApproach0SlidingWindow {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        final int L = s.length();
        char[] chs = s.toCharArray();
        int[] freq = new int[256];

        int distinct = 0;
        int longest = 0;

        int lo = 0, hi = 0;
        while (hi < L) {
            if (freq[chs[hi]]++ == 0)
                ++distinct;

            while (distinct > k) {
                if (--freq[chs[lo]] == 0)
                    --distinct;
                ++lo;
            }

            // please pay attention to the relative sequence of the below two lines,
            // which defines the running `length`.
            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}