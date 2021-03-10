/**
 * https://leetcode.com/problems/maximal-square/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NC)
 * 
 * `dp[row][col]` is only related to `dp[row - 1][col]`, `dp[row - 1][col - 1]` (current rows), 
 *  and `dp[row][col - 1]` (previous rows). So to keep two rows are enough.
 * 
 * References:
 *  https://leetcode.com/problems/maximal-square/discuss/61803/C%2B%2B-space-optimized-DP
 */
package com.an7one.leetcode.lvl4.lc0221;

public class SolutionApproach0DP1Dimen1 {
    public int maximalSquare(char[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return 0;
        
        final int NR = matrix.length, NC = matrix[0].length;
        
        int maxLen = 0;
        int[] prevRows = new int[NC];
        int[] curRows = new int[NC];
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(row == 0 || col == 0 || matrix[row][col] == '0'){
                    curRows[col] = matrix[row][col] - '0';
                }else{
                    curRows[col] = Math.min(prevRows[col - 1], Math.min(prevRows[col], curRows[col - 1])) + 1;
                }
                
                maxLen = Math.max(maxLen, curRows[col]);
            }
            
            // be careful here
            // do NOT assign by reference
            prevRows = curRows.clone();
        }
        
        return maxLen * maxLen;
    }
}