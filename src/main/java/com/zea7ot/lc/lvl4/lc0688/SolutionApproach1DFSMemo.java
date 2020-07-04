/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/knight-probability-in-chessboard/discuss/206720/Share-My-Intuitive-Recursive-Java-Solution
 */
package com.zea7ot.lc.lvl4.lc0688;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1DFSMemo {
    private static int[][] DIRS = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

    public double knightProbability(int N, int K, int r, int c) {
        Map<String, Double> memo = new HashMap<String, Double>();
        return dfs(r, c, K, N, memo);
    }
    
    private double dfs(int row, int col, int K, int N, Map<String, Double> memo){
        if(row < 0 || row >= N || col < 0 || col >= N || K < 0) return 0;
        if(K == 0) return 1;
        
        String key = K + "," + row + "," + col;
        if(memo.containsKey(key)) return memo.get(key);
        
        double res = 0;
        for(final int[] DIR : DIRS){
            int r = row + DIR[0], c = col + DIR[1];
            res += dfs(r, c, K - 1, N, memo);
        }
        memo.put(key, res / 8.0);
        return res / 8.0;
    }
}