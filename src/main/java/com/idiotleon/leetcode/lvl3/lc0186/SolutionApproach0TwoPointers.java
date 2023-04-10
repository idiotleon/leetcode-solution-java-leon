/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0186;

public class SolutionApproach0TwoPointers {
    public void reverseWords(char[] chs) {
        // sanity check
        if (chs == null || chs.length == 0)
            return;

        final int L = chs.length;
        reverse(0, L - 1, chs);

        int lo = 0, hi = 0;
        while (hi < L) {
            while (hi < L && chs[hi] != ' ')
                ++hi;

            reverse(lo, hi - 1, chs);
            lo = hi + 1;
            ++hi;
        }
    }

    private void reverse(int lo, int hi, final char[] CHS) {
        while (lo < hi)
            swap(lo++, hi--, CHS);
    }

    private void swap(int i, int j, final char[] CHS) {
        char temp = CHS[i];
        CHS[i] = CHS[j];
        CHS[j] = temp;
    }
}