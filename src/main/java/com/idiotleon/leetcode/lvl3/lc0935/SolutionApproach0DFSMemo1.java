/**
 * https://leetcode.com/problems/knight-dialer/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  
 */
package com.idiotleon.leetcode.lvl3.lc0935;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSMemo1 {
    private static final int[][] DIRS = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    private static final int MOD = (int)1e9 + 7;
    
    public int knightDialer(int N) {
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        
        Map<String, Long> memo = new HashMap<String, Long>();

        long ans = 0;
        for(int row = 0; row < 4; ++row)
            for(int col = 0; col < 3; ++col)
                ans = (ans + dfs(row, col, N, memo)) % MOD;
        
        return (int)ans;
    }
    
    private long dfs(int row, int col, final int N, Map<String, Long> memo){
        if(row < 0 || row >= 4 || col < 0 || col >= 3 || (row == 3 && col != 1))
            return 0;
        
        if(N == 1) return 1;
        
        String key = row + "-" + col + "-" + N;
        if(memo.containsKey(key)) return memo.get(key);
        
        long ans = 0;
        for(int d = 0; d < 8; ++d)
            ans += dfs(row + DIRS[d][0], col + DIRS[d][1], N - 1, memo) % MOD;
        
        memo.put(key, ans);
        return ans;
    }
}