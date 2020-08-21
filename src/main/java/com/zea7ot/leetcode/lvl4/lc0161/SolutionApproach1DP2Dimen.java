/**
 * https://leetcode.com/problems/one-edit-distance/
 * 
 * Time Complexity:     O(LEN_S * LEN_T)
 * Space Complexity:    O(LEN_S * LEN_T)
 */
package com.zea7ot.leetcode.lvl4.lc0161;

public class SolutionApproach1DP2Dimen {
    public boolean isOneEditDistance(String s, String t) {
        // sanity check
        if (s == null || t == null || s.equals(t))
            return false;

        final int LEN_S = s.length(), LEN_T = t.length();
        final char[] CHS_S = s.toCharArray(), CHS_T = t.toCharArray();

        // not necessary
        // if(LEN_S > LEN_T)
        // return isOneEditDistance(t, s);

        int[][] costs = new int[LEN_S + 1][LEN_T + 1];
        for (int row = 0; row <= LEN_S; ++row)
            costs[row][0] = row;
        for (int col = 0; col <= LEN_T; ++col)
            costs[0][col] = col;

        for (int idxS = 0; idxS < LEN_S; ++idxS) {
            for (int idxT = 0; idxT < LEN_T; ++idxT) {
                if (CHS_S[idxS] == CHS_T[idxT]) {
                    costs[idxS + 1][idxT + 1] = costs[idxS][idxT];
                } else {
                    int replace = costs[idxS][idxT];
                    int delete = costs[idxS + 1][idxT];
                    int insert = costs[idxS][idxT + 1];

                    costs[idxS + 1][idxT + 1] = Math.min(insert, Math.min(replace, delete));
                    ++costs[idxS + 1][idxT + 1];
                }
            }
        }

        return costs[LEN_S][LEN_T] == 1;
    }
}