/**
 * https://leetcode.com/problems/edit-distance/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2)
 * 
 * References:
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)/424626
 *  https://web.stanford.edu/class/cs124/lec/med.pdf
 */
package com.an7one.leetcode.lvl4.lc0072;

public class SolutionApproach0DP2Dimen {
    public int minDistance(String word1, String word2) {
        final int L1 = word1.length(), L2 = word2.length();
        final char[] CHS1 = word1.toCharArray(), CHS2 = word2.toCharArray();

        int[][] costs = new int[L1 + 1][L2 + 1];
        for (int idx1 = 0; idx1 <= L1; ++idx1) {
            costs[idx1][0] = idx1;
        }

        for (int idx2 = 0; idx2 <= L2; ++idx2) {
            costs[0][idx2] = idx2;
        }

        for (int idx1 = 0; idx1 < L1; ++idx1) {
            for (int idx2 = 0; idx2 < L2; ++idx2) {
                if (CHS1[idx1] == CHS2[idx2])
                    costs[idx1 + 1][idx2 + 1] = costs[idx1][idx2];
                else {
                    int insert = costs[idx1][idx2 + 1];
                    int replace = costs[idx1][idx2];
                    int delete = costs[idx1 + 1][idx2];

                    costs[idx1 + 1][idx2 + 1] = Math.min(insert, Math.min(replace, delete));
                    ++costs[idx1 + 1][idx2 + 1];
                }
            }
        }

        return costs[L1][L2];
    }
}