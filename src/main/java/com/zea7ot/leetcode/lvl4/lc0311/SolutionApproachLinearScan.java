/**
 * https://leetcode.com/problems/sparse-matrix-multiplication/
 */
package com.zea7ot.leetcode.lvl4.lc0311;

public class SolutionApproachLinearScan {
    public int[][] multiply(int[][] A, int[][] B) {
        final int nr = A.length, nc = B[0].length, nk = A[0].length;
        
        int[][] ans = new int[nr][nc];
        
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                for(int k = 0; k < nk; k++){
                    if(A[row][k] == 0 || B[k][col] == 0) continue;
                    ans[row][col] += A[row][k] * B[k][col];
                }
            }
        }
        
        return ans;
    }
}