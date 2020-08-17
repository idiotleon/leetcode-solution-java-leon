/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * how about k repeating characters being allowed?
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0003.followup;

public class SolutionApproach0SlidingWindow {
    public int lengthOfLongestSubstring(String s, int k) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        int[] freq = new int[256];
        int lo = 0, hi = 0, threshold = 0;
        while (hi < L) {
            char ch = s.charAt(hi);
            ++freq[ch];
            if (freq[ch] > 1)
                ++threshold;

            while (threshold > 0) {
                char temp = s.charAt(lo);
                if (freq[temp] > k) {
                    --threshold;
                }
                --freq[temp];
                lo++;
            }

            longest = Math.max(longest, hi - lo + 1);
            hi++;
        }

        return longest;
    }
}