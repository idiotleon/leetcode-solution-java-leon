/**
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(4) / O(L) ~ O(1) / O(L)
 * 
 * `FREQS[]` keeps accounts of the frequencies OUTSIDE the sliding window
 * 
 * References:
 *  https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/408978/JavaC%2B%2BPython-Sliding-Window
 */
package com.an7one.leetcode.lvl4.lc1234;

public class SolutionApproach0SlidingWindow {
    public int balancedString(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        final int[] FREQS = new int[26];
        for (final char CH : CHS) {
            ++FREQS[CH - 'A'];
        }

        final int K = L / 4;
        if (isValid(FREQS, K))
            return 0;

        int lo = 0, hi = 0;
        int shortest = L;

        while (hi < L) {
            --FREQS[CHS[hi] - 'A'];

            while (isValid(FREQS, K)) {
                shortest = Math.min(shortest, hi - lo + 1);
                ++FREQS[CHS[lo] - 'A'];
                ++lo;
            }

            ++hi;
        }

        return shortest;
    }

    private boolean isValid(final int[] FREQS, final int K) {
        for (final int FREQ : FREQS) {
            if (FREQ > K)
                return false;
        }

        return true;
    }
}