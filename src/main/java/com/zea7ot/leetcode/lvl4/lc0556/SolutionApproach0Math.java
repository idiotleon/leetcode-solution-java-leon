/**
 * 
 */
package com.zea7ot.leetcode.lvl4.lc0556;

public class SolutionApproach0Math {
    public int nextGreaterElement(int n) {
        char[] chs = String.valueOf(n).toCharArray();
        final int N = chs.length;

        int i = N - 2;
        while (i >= 0 && chs[i] >= chs[i + 1])
            --i;
        if (i < 0)
            return -1;

        int j = N - 1;
        while (chs[j] <= chs[i])
            --j;

        swap(i, j, chs);
        reverseSince(i + 1, chs);

        try {
            return Integer.parseInt(String.valueOf(chs));
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void reverseSince(int start, char[] chs) {
        final int N = chs.length;
        int end = N - 1;
        while (start < end)
            swap(start++, end--, chs);
    }

    private void swap(int i, int j, char[] chs) {
        chs[i] ^= chs[j];
        chs[j] ^= chs[i];
        chs[i] ^= chs[j];
    }
}