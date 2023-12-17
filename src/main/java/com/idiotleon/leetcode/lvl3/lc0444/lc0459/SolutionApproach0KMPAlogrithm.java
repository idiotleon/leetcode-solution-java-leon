/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.idiotleon.leetcode.lvl3.lc0444.lc0459;

public class SolutionApproach0KMPAlogrithm {
    public boolean repeatedSubstringPattern(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return true;

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        int[] kmpTable = new int[L];
        int i = 1, j = 0;
        while (i < L) {
            if (CHS[j] == CHS[i]) {
                kmpTable[i++] = ++j;
            } else if (j == 0) {
                ++i;
            } else {
                j = kmpTable[j - 1];
            }
        }

        return kmpTable[L - 1] != 0 && L % (L - kmpTable[L - 1]) == 0;
    }
}