/**
 * https://leetcode.com/problems/long-pressed-name/
 * 
 * Time Complexity:     O(`LEN_N`) + O(`LEN_T`) ~ O(`LEN_T`)
 * Space Complexity:    O(`LEN_N`) / O(1) + O(`LEN_T`) / O(1) ~ O(`LEN_T`) / O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0925;

public class SolutionApproach0TwoPointers {
    public boolean isLongPressedName(String name, String typed) {
        final int LEN_N = name.length(), LEN_T = typed.length();
        final char[] CHS_N = name.toCharArray(), CHS_T = typed.toCharArray();

        int idxN = 0, idxT = 0;

        while (idxN < LEN_N && idxT < LEN_T) {
            final char CH_N = CHS_N[idxN];
            final char CH_T = CHS_T[idxT];

            if (CH_N == CH_T) {
                ++idxN;
                ++idxT;
            } else {
                if (idxT == 0 || CHS_T[idxT - 1] != CH_T) {
                    return false;
                }

                ++idxT;
            }
        }

        while (idxT < LEN_T && CHS_T[idxT - 1] == CHS_T[idxT]) {
            ++idxT;
        }

        return idxN == LEN_N && idxT == LEN_T;
    }
}
