/**
 * https://leetcode.com/problems/maximal-square/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NC)
 * 
 * References:
 *  https://leetcode.com/problems/maximal-square/discuss/61803/C++-space-optimized-DP/63371
 *  https://leetcode.com/problems/maximal-square/discuss/61803/C%2B%2B-space-optimized-DP
 */
package com.idiotleon.leetcode.lvl4.lc0221;

public class SolutionApproach0DP1Dimen {
    public int maximalSquare(char[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return 0;
        
        final int NR = matrix.length, NC = matrix[0].length;
        
        int maxLen = 0;
        // the left-top value
        int prev = 0;
        int[] curRow = new int[NC];
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                int temp = curRow[col];
                if(row == 0 || col == 0 || matrix[row][col] == '0'){
                    curRow[col] = matrix[row][col] - '0';
                }else{
                    curRow[col] = Math.min(prev, Math.min(curRow[col - 1], curRow[col])) + 1;
                }
                
                maxLen = Math.max(maxLen, curRow[col]);
                prev = temp;
            }
        }
        
        return maxLen * maxLen;
    }
}