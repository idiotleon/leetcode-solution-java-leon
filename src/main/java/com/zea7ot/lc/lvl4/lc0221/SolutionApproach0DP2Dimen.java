/**
 * https://leetcode.com/problems/maximal-square/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * `dp[row][col]` represents the length of the square, of which lower right corner is located at (row, col).
 *      What's more, `dp[row][col - 1]` and `dp[row][col - 1]` cannot be larger than `dp[row - 1][col - 1]` by 1.
 * 
 * References:  
 *  https://leetcode.com/problems/maximal-square/discuss/61802/Extremely-Simple-Java-Solution-:)/63328
 *  https://leetcode.com/problems/maximal-square/discuss/600149/Python-Thinking-Process-Diagrams-DP-Approach
 *  https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
package com.zea7ot.lc.lvl4.lc0221;

public class SolutionApproach0DP2Dimen {
    public int maximalSquare(char[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        final int NR = matrix.length, NC = matrix[0].length;
        int[][] dp = new int[NR + 1][NC + 1];
        
        int maxLen = 0;
        for(int row = 1; row <= NR; row++){
            for(int col = 1; col <= NC; col++){
                if(matrix[row - 1][col - 1] == '1'){
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                    
                    maxLen = Math.max(maxLen, dp[row][col]);
                } else dp[row][col] = 0;
            }
        }
        
        return maxLen * maxLen;
    }
}