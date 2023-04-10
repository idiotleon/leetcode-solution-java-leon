/**
 * https://leetcode.com/problems/repeated-string-match/
 * 
 * Time Complexity:     O(LEN1 + LEN2) ~ O(max(LEN1, LEN2))
 * Space Complexity:    O(LEN2)
 */
package com.idiotleon.leetcode.lvl3.lc0686;

public class SolutionApproach0KMPAlgorithm {
    public int repeatedStringMatch(String str1, String str2) {
        // sanity check
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty())
            return -1;

        final int LEN1 = str1.length(), LEN2 = str2.length();
        final char[] CHS1 = str1.toCharArray(), CHS2 = str2.toCharArray();
        final int[] KMP = new int[LEN2];
        int i = 1, j = 0;
        while (i < LEN2) {
            if (CHS2[i] == CHS2[j]) {
                KMP[i++] = ++j;
            } else if (j == 0) {
                ++i;
            } else {
                j = KMP[j - 1];
            }
        }

        i = 0;
        j = 0;
        int count = 0;
        while (j < LEN2) {
            if (i == LEN1) {
                // to repeat A once
                ++count;
                // to reset i
                i = 0;
            } else if (CHS1[i] == CHS2[j]) {
                ++i;
                ++j;
            } else {
                if ((count - 1) * LEN1 + i > j) {
                    return -1;
                } else if (j == 0) {
                    ++i;
                } else {
                    j = KMP[j - 1];
                }
            }
        }

        return count + 1;
    }
}