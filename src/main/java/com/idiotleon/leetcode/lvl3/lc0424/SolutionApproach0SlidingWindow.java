/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
 */
package com.idiotleon.leetcode.lvl3.lc0424;

public class SolutionApproach0SlidingWindow {
    public int characterReplacement(String s, int k) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        final int[] FREQS = new int[26];
        int maxCount = 0;
        int lo = 0, hi = 0;

        while (hi < L) {
            maxCount = Math.max(maxCount, ++FREQS[CHS[hi] - 'A']);

            final int LEN = hi - lo + 1;
            if (maxCount + k < LEN)
                --FREQS[CHS[lo++] - 'A'];

            ++hi;
        }

        return L - lo;
    }
}