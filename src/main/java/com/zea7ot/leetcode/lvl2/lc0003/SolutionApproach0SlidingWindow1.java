
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * please be cautious that the `s` contains not just lower case letters
 */
package com.zea7ot.leetcode.lvl2.lc0003;

public class SolutionApproach0SlidingWindow1 {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        char[] chs = s.toCharArray();
        int[] freq = new int[128];

        int lo = 0, hi = 0;
        while (hi < L) {
            lo = Math.max(lo, freq[chs[hi]]);
            longest = Math.max(longest, hi - lo + 1);
            freq[chs[hi]] = hi + 1;

            ++hi;
        }

        return longest;
    }
}