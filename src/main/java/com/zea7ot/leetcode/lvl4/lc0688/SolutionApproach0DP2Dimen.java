/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 * 
 * Time Complexity:     O(K * N * N * 4) + O(N * N) ~ O(K * (N ^ 2))
 * 
 * Space Complexity:    O(N * N)
 * 
 * since only `k` and `k-1` are used at every step, one can make the new K-th board a variable.
 * 
 * References:
 *  https://leetcode.com/problems/knight-probability-in-chessboard/discuss/162722/Simple-Java-DP-solution-with-explanation
 */
package com.zea7ot.leetcode.lvl4.lc0688;

public class SolutionApproach0DP2Dimen {
    private static int[][] DIRS = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        for(int step = 1; step <= K; step++){
            double[][] dp1 = new double[N][N];
            for(int row = 0; row < N; row++){
                for(int col = 0; col < N; col++){
                    for(final int[] DIR : DIRS){
                        int nr = row - DIR[0], nc = col - DIR[1];
                        if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        dp1[row][col] += dp[nr][nc] / 8.0;
                    }
                }
            }
            dp = dp1;
        }
        
        double ans = 0;
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                ans += dp[row][col];
            }
        }
        return ans;
    }
}