/**
 * https://leetcode.com/problems/isomorphic-strings/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(256 * 2) ~ O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0205;

public class SolutionApproach0LinearScan2 {
    public boolean isIsomorphic(String s, String t) {
        // sanity check
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || t.length() != s.length())
            return false;

        final int LEN_S = s.length();
        final int[] DICT = new int[512];
        for (int i = 0; i < LEN_S; ++i) {
            final char CH_S = s.charAt(i);
            final char CH_T = t.charAt(i);

            if (DICT[CH_S] != DICT[CH_T + 256])
                return false;

            DICT[CH_S] = DICT[CH_T + 256] = i + 1;
        }

        return true;
    }
}