/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution/154421
 */
package com.zea7ot.lc.lvl3.lc0005;

public class SolutionApproach0ExpandPalindrome {
    public String longestPalindrome(String s) {
        // sanity check
        if (s == null || s.length() < 2)
            return s;

        final int L = s.length();
        char[] chs = s.toCharArray();
        int[] start = new int[1], end = new int[1];

        for (int i = 0; i < L; ++i) {
            expand(i, i, chs, start, end);
            expand(i, i + 1, chs, start, end);
        }

        return s.substring(start[0], end[0] + 1);
    }

    private void expand(int lo, int hi, char[] chs, int[] start, int[] end) {
        final int L = chs.length;
        while (lo >= 0 && hi < L && chs[lo] == chs[hi]) {
            --lo;
            ++hi;
        }

        // to get back to the previous/last valid position
        ++lo;
        --hi;

        if (hi - lo + 1 > end[0] - start[0] + 1) {
            start[0] = lo;
            end[0] = hi;
        }
    }
}