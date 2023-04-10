/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 * 
 * Time Complexity:     O(K * N * N * 4) + O(N * N) ~ O(K * (N ^ 2))
 * 
 * Space Complexity:    O(K * N * N)
 * 
 * References:
 *  https://leetcode.com/problems/knight-probability-in-chessboard/discuss/108214/My-easy-understand-dp-solution
 */
package com.idiotleon.leetcode.lvl4.lc0688;

public class SolutionApproach0DP3Dimen {
    private static int[][] DIRS = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K + 1][N][N];
        dp[0][r][c] = 1;
        for(int step = 1; step <= K; step++){
            for(int row = 0; row < N; row++){
                for(int col = 0; col < N; col++){
                    for(final int[] DIR : DIRS){
                        int nr = row + DIR[0], nc = col + DIR[1];
                        if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        dp[step][row][col] += dp[step - 1][nr][nc] / 8.0;
                    }
                }
            }
        }
        
        double ans = 0;
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                ans += dp[K][row][col];
            }
        }
        return ans;
    }
}