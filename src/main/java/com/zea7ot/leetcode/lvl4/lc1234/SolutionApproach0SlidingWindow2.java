/**
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(4) / O(L) ~ O(1) / O(L)
 * 
 * `freq[]` keeps acount of the frequencies OUTSIDE the sliding window
 * 
 * References:
 *  https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/408978/JavaC%2B%2BPython-Sliding-Window
 */
package com.zea7ot.leetcode.lvl4.lc1234;

public class SolutionApproach0SlidingWindow2 {
    private static final char[] LETTERS = new char[] { 'Q', 'W', 'E', 'R' };

    public int balancedString(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;
        final int L = s.length();
        char[] chs = s.toCharArray();
        final int K = L / 4;

        int[] freq = new int[4];
        for (char ch : chs)
            ++freq[hash(ch)];

        int lo = 0, hi = 0;
        int shortest = L;

        while (hi < L) {
            --freq[hash(chs[hi])];

            while (isValid(freq, K)) {
                shortest = Math.min(shortest, hi - lo + 1);
                ++freq[hash(chs[lo])];
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