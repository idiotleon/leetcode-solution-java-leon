package com.idiotleon.leetcode.lvl4.lc0556;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/next-greater-element-iii/description/">LC0556</a>
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Math {
    public int nextGreaterElement(int n) {
        final char[] chs = String.valueOf(n).toCharArray();
        final int N = chs.length;

        int lo = N - 2;
        while (lo >= 0 && chs[lo] >= chs[lo + 1]) {
            --lo;
        }

        if (lo < 0) {
            return -1;
        }

        int hi = N - 1;
        while (chs[hi] <= chs[lo]) {
            --hi;
        }

        swap(lo, hi, chs);
        reverseSince(lo + 1, chs);

        try {
            return Integer.parseInt(String.valueOf(chs));
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void reverseSince(int start, final char[] chs) {
        final int N = chs.length;
        int end = N - 1;
        while (start < end) {
            swap(start++, end--, chs);
        }
    }

    private void swap(final int i, final int j, final char[] chs) {
        chs[i] ^= chs[j];
        chs[j] ^= chs[i];
        chs[i] ^= chs[j];
    }
}