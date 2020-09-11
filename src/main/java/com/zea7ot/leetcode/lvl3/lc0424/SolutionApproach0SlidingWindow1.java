/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
 */
package com.zea7ot.leetcode.lvl3.lc0424;

public class SolutionApproach0SlidingWindow1 {
    public int characterReplacement(String s, int k) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        final int[] FREQS = new int[26];
        int longest = 0;
        int maxCount = 0;
        int lo = 0, hi = 0;

        while (hi < L) {
            maxCount = Math.max(maxCount, ++FREQS[CHS[hi] - 'A']);

            if (maxCount + k >= hi - lo + 1) {
                longest = Math.max(maxCount, hi - lo + 1);
            } else {
                --FREQS[CHS[lo++] - 'A'];
            }

            ++hi;
        }

        return longest;
    }
}