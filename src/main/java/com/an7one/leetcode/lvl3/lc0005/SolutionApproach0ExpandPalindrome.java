package com.an7one.leetcode.lvl3.lc0005;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution/154421
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0ExpandPalindrome {
    public String longestPalindrome(String str) {
        // sanity check
        if (str == null || str.length() < 2)
            return str;

        final int L = str.length();
        char[] chs = str.toCharArray();
        int[] idxStart = new int[1], idxEnd = new int[1];

        for (int i = 0; i < L; ++i) {
            expand(i, i, chs, idxStart, idxEnd);
            expand(i, i + 1, chs, idxStart, idxEnd);
        }

        return str.substring(idxStart[0], idxEnd[0] + 1);
    }

    private void expand(int lo, int hi, char[] chs, int[] idxStart, int[] idxEnd) {
        final int L = chs.length;
        while (lo >= 0 && hi < L && chs[lo] == chs[hi]) {
            --lo;
            ++hi;
        }

        // to get back to the previous/last valid position
        ++lo;
        --hi;

        if (hi - lo + 1 > idxEnd[0] - idxStart[0] + 1) {
            idxStart[0] = lo;
            idxEnd[0] = hi;
        }
    }
}