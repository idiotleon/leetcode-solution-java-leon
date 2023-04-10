/**
 * https://leetcode.com/problems/sparse-matrix-multiplication/
 * 
 * Time Complexity:     O(NR_A * NC_B)
 * Space Compleixty:    O(NR_A * NC_B)
 */
package com.idiotleon.leetcode.lvl4.lc0311;

public class SolutionApproach0Math {
    public int[][] multiply(int[][] A, int[][] B) {
        final int NR_A = A.length, NC_B = B[0].length, NC_A = A[0].length;

        int[][] ans = new int[NR_A][NC_B];

        for (int row = 0; row < NR_A; ++row) {
            for (int col = 0; col < NC_B; ++col) {
                for (int k = 0; k < NC_A; ++k) {
                    // the line below can be ommitted
                    if (A[row][k] == 0 || B[k][col] == 0)
                        continue;

                    ans[row][col] += A[row][k] * B[k][col];
                }
            }
        }

        return ans;
    }
}