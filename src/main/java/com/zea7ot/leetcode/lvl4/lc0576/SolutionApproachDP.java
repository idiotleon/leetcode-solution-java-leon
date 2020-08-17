/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 * 
 * https://leetcode.com/problems/out-of-boundary-paths/discuss/102967/Java-Solution-DP-with-space-compression
 * DP[i][j][k] stands for how many possible ways to walk into cell j,k in step i, 
 * DP[i][j][k] only depends on DP[i - 1][j][k], 
 * so we can compress 3 dimensional dp array to 2 dimensional.
 * 
 * Space Compression:
 * https://leetcode.com/problems/out-of-boundary-paths/discuss/102967/Java-Solution-DP-with-space-compression/266686
 */
package com.zea7ot.leetcode.lvl4.lc0576;

public class SolutionApproachDP {
    private static final int[] DIRS = {0, 1, 0, -1, 0};
    public int findPaths(int m, int n, int N, int i, int j) {
        
        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int ans = 0;
        
        for(int k = 0; k < N; k++){
            // the k-th move
            int[][] dpNext = new int[m][n];
            
            for(int row = 0; row < m; row++){
                for(int col = 0; col < n; col++){
                    if(dp[row][col] == 0) continue;
                    
                    for(int d = 0; d < 4; d++){
                        int r = row + DIRS[d], c = col + DIRS[d + 1];
                        
                        if(r < 0 || r >= m || c < 0 || c >= n){
                            ans = (ans + dp[row][col]) % MOD;
                        }else{
                            dpNext[r][c] = (dpNext[r][c] + dp[row][col]) % MOD;
                        }
                    }
                }
            }

            dp = dpNext;
        }
        
        return ans;
    }
}