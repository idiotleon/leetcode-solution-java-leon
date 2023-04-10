/**
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * 
 * Time Complexity:     O(5 * L) ~ O(L)
 * Space Complexity:    O(2 ^ 5) ~ O(1)
 * 
 * to record the first index when a state occurs,
 * the the last index is the length of all even-vowel substring.
 * 
 * whenever a vowel occurs, we flip the bit (XOR), so to turn odd to even, or even to odd
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/hashtable/leetcode-1371-find-the-longest-substring-containing-vowels-in-even-counts/
 *  https://www.youtube.com/watch?v=tAlQxFvak2U
 */
package com.idiotleon.leetcode.lvl4.lc1371;

import java.util.Arrays;

public class SolutionApproach0PrefixSums {
    public int findTheLongestSubstring(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;
        final int L = s.length();
        char[] chs = s.toCharArray();
        final char[] VOWELS = { 'a', 'e', 'i', 'o', 'u' };

        // state -> indexes of first occurrences
        int[] idxes = new int[1 << 5];
        Arrays.fill(idxes, Integer.MAX_VALUE);
        idxes[0] = -1;
        int state = 0;
        int longest = 0;
        for (int i = 0; i < L; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (chs[i] == VOWELS[j])
                    state ^= 1 << j;
            }

            if (idxes[state] == Integer.MAX_VALUE)
                idxes[state] = i;
            longest = Math.max(longest, i - idxes[state]);
        }

        return longest;
    }
}