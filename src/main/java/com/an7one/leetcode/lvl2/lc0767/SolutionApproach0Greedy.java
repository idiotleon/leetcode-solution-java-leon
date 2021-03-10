/**
 * https://leetcode.com/problems/reorganize-string/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) + O(26) ~ O(max(L, 26))
 */
package com.an7one.leetcode.lvl2.lc0767;

public class SolutionApproach0Greedy {
    private static final char ALPHABET = 26;

    public String reorganizeString(String S) {
        // santiy check
        if (S == null || S.isEmpty())
            return "";

        final int L = S.length();
        final char[] CHS = S.toCharArray();
        int[] freq = new int[ALPHABET];

        int maxFreq = 0, idxMax = 0;
        for (int i = 0; i < L; i++) {
            int idx = CHS[i] - 'a';
            if (++freq[idx] > (L + 1) / 2)
                return "";

            if (freq[idx] > maxFreq) {
                maxFreq = freq[idx];
                idxMax = idx;
            }
        }

        char[] res = new char[L];
        int idx = 0;
        // to align the most frequent char(s)/letter(s) intermittently
        while (freq[idxMax] > 0) {
            res[idx] = (char) ('a' + idxMax);
            idx += 2;
            --freq[idxMax];
        }

        // to align the rest of letters intermittently
        for (int i = 0; i < ALPHABET; ++i) {
            while (freq[i] > 0) {
                if (idx >= L)
                    idx = 1;

                res[idx] = (char) (i + 'a');
                idx += 2;
                --freq[i];
            }
        }

        return String.valueOf(res);
    }
}