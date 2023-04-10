package com.idiotleon.leetcode.lvl3.lc0005;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">LC0005</a>
 * <p>
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution/154421">LC Discussion</a>
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