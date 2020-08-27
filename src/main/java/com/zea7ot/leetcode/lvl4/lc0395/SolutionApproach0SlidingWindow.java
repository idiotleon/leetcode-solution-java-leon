/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 
 * Time Complexity:     O(26 * L) ~ O(L)
 * Space Complexity:    O(1) / O(L) + O(26) ~ O(1) / O(L)
 * 
 * References:
 *  https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87739/Java-Strict-O(N)-Two-Pointer-Solution/188126
 */
package com.zea7ot.leetcode.lvl4.lc0395;

import java.util.Arrays;

public class SolutionApproach0SlidingWindow {
    public int longestSubstring(String s, int k) {
        int longest = 0;
        // sanity check
        if (s == null || s.isEmpty())
            return longest;

        final int L = s.length();
        if (k < 2)
            return L;

        final char[] CHS = s.toCharArray();

        int[] freq = new int[26];
        for (int i = 1; i <= 26; ++i) {
            Arrays.fill(freq, 0);

            int lo = 0, hi = 0;
            int distinct = 0;

            while (hi < L) {
                boolean isValid = true;
                if (freq[CHS[hi] - 'a']++ == 0)
                    ++distinct;

                while (distinct > i) {
                    if (--freq[CHS[lo] - 'a'] == 0)
                        --distinct;

                    ++lo;
                }

                for (int num : freq)
                    if (num > 0 && num < k)
                        isValid = false;

                if (isValid)
                    longest = Math.max(longest, hi - lo + 1);

                ++hi;
            }
        }

        return longest;
    }
}