/**
 * https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1) + O(26) ~ O(L) / O(1)
 */
package com.idiotleon.leetcode.lvl2.lc1100;

public class SolutionApproach0SlidingWindow {
    public int numKLenSubstrNoRepeats(String str, final int K) {
        // sanity check
        if (str == null || str.isEmpty() || str.length() < K)
            return 0;

        final int L = str.length();
        final char[] CHS = str.toCharArray();
        int lo = 0, hi = 0;
        int count = 0;

        final int[] FREQS = new int[26];

        int distinct = 0;
        while (hi < L) {
            if (FREQS[CHS[hi] - 'a']++ == 0)
                ++distinct;

            if (distinct == K)
                ++count;

            if (hi - lo + 1 == K) {
                if (--FREQS[CHS[lo] - 'a'] == 0)
                    --distinct;
                ++lo;
            }

            ++hi;
        }

        return count;
    }
}
