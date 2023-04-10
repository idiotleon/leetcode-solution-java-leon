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
package com.idiotleon.leetcode.lvl4.lc1234;

public class SolutionApproach0SlidingWindow3 {
    private static final char[] LETTERS = new char[] { 'Q', 'W', 'E', 'R' };

    public int balancedString(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;
        final int L = s.length();
        final char[] CHS = s.toCharArray();
        final int K = L / 4;

        final int[] FREQS = new int[4];
        for (final char CH : CHS)
            ++FREQS[hash(CH)];

        int lo = 0, hi = 0;
        int shortest = L;

        while (hi < L) {
            --FREQS[hash(CHS[hi])];

            while (isValid(FREQS, K)) {
                shortest = Math.min(shortest, hi - lo + 1);
                ++FREQS[hash(CHS[lo])];
                ++lo;
            }

            if (lo == L)
                break;
            ++hi;
        }

        return shortest;
    }

    private boolean isValid(int[] freq, final int K) {
        int max = 0;
        for (char ch : LETTERS)
            max = Math.max(max, freq[hash(ch)]);

        return max <= K;
    }

    private int hash(char ch) {
        switch (ch) {
            case 'Q':
                return 0;
            case 'W':
                return 1;
            case 'E':
                return 2;
            case 'R':
                return 3;
        }

        return -1;
    }
}