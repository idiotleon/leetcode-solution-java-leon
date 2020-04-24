/**
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * This is a typical 2D DP problem, we can store value in 2D DP array, 
 * but since we only need to use value at dp[i - 1][j] and dp[i][j - 1] to update dp[i][j], 
 * we don't need to store the whole 2D table, but instead store value in an 1D array, 
 * and update data by using dp[j] = dp[j] + dp[j - 1], 
 * where here dp[j] corresponding to the dp[i - 1][j],
 * and dp[j - 1] corresponding to the dp[i][j - 1] in the 2D array
 * 
 * https://leetcode.com/problems/unique-paths-ii/discuss/23250/Short-JAVA-solution
 */

package main.java.lcidiot.lc.lvl2.lc0063;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        
        for(int[] row : obstacleGrid){
            for(int j = 0; j < width; j++){
                if(row[j] == 1) dp[j] = 0;
                else if(j > 0) dp[j] += dp[j - 1];
            }
        }
        
        return dp[width - 1];
    }
}