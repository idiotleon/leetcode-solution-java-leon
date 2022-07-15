package com.an7one.leetcode.lvl2.lc0767;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/reorganize-string/">LC0767</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) + O(26) ~ O(max(L, 26))
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Greedy {
    private static final char ALPHABET = 26;

    public String reorganizeString(String S) {
        // sanity check
        if (S == null || S.isEmpty())
            return "";

        final int L = S.length();
        final char[] CHS = S.toCharArray();
        final int[] freqs = new int[ALPHABET];

        int maxFreq = 0, idxMax = 0;
        for (int i = 0; i < L; i++) {
            int idx = CHS[i] - 'a';
            if (++freqs[idx] > (L + 1) / 2)
                return "";

            if (freqs[idx] > maxFreq) {
                maxFreq = freqs[idx];
                idxMax = idx;
            }
        }

        final char[] res = new char[L];
        int idx = 0;
        // to align the most frequent char(s)/letter(s) intermittently
        while (freqs[idxMax] > 0) {
            res[idx] = (char) ('a' + idxMax);
            idx += 2;
            --freqs[idxMax];
        }

        // to align the rest of letters intermittently
        for (int i = 0; i < ALPHABET; ++i) {
            while (freqs[i] > 0) {
                if (idx >= L)
                    idx = 1;

                res[idx] = (char) (i + 'a');
                idx += 2;
                --freqs[i];
            }
        }

        return String.valueOf(res);
    }
}