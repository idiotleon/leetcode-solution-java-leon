/**
 * https://leetcode.com/problems/isomorphic-strings/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(256 * 2) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution/59438
 *  https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution
 *  https://leetcode.com/problems/isomorphic-strings/discuss/57810/Short-Java-solution-without-maps
 */
package com.an7one.leetcode.lvl2.lc0205;

import java.util.Arrays;

public class SolutionApproach0LinearScan1 {
    public boolean isIsomorphic(String s, String t) {
        // sanity check
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || t.length() != s.length())
            return false;

        final int L = s.length();
        final int[] DICT_S = new int[256];
        Arrays.fill(DICT_S, -1);
        final int[] DICT_T = new int[256];
        Arrays.fill(DICT_T, -1);

        for (int i = 0; i < L; ++i) {
            final char CH_S = s.charAt(i);
            final char CH_T = t.charAt(i);

            if (DICT_S[CH_S] != DICT_T[CH_T]) {
                return false;
            }

            DICT_S[CH_S] = i;
            DICT_T[CH_T] = i;
        }

        return true;
    }
}