/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * 
 * Time Complexity: O(NR * NC)
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/441306/JavaC%2B%2BPython-DP-solution
 */
package com.idiotleon.leetcode.lvl3.lc1277;

public class SolutionApproach0DP2D {
    public int countSquares(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        final int NR = matrix.length, NC = matrix[0].length;
        int ans = 0;
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(matrix[row][col] > 0 && row > 0 && col > 0){
                    matrix[row][col] = Math.min(matrix[row - 1][col - 1], Math.min(matrix[row - 1][col], matrix[row][col - 1])) + 1;
                }
                
                ans += matrix[row][col];
            }
        }
        
        return ans;
    }
}