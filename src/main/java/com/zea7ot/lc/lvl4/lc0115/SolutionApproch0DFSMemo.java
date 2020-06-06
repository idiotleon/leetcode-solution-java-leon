/**
 * https://leetcode.com/problems/distinct-subsequences/
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(M * N)
 * 
 * References:
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37413/Concise-JAVA-solution-based-on-DP
 *  https://leetcode.wang/leetcode-115-Distinct-Subsequences.html
 */
package com.zea7ot.lc.lvl4.lc0115;

import java.util.Arrays;

public class SolutionApproch0DFSMemo {
    public int numDistinct(String s, String t) {
        final int M = s.length(), N = t.length();
        int[][] memo = new int[M][N];
        for(int[] row : memo) Arrays.fill(row, -1);
        return dfs(s.toCharArray(), 0, t.toCharArray(), 0, memo);
    }
    
    private int dfs(char[] chsS, int idxS, 
                    char[] chsT, int idxT, 
                    int[][] memo){
        final int M = chsS.length, N = chsT.length;
        
        if(idxT == N) return 1;
        if(idxS == M) return 0;
        
        if(memo[idxS][idxT] != -1) return memo[idxS][idxT];
        
        int count = 0;
        if(chsS[idxS] == chsT[idxT]){
            count += dfs(chsS, idxS + 1, chsT, idxT + 1, memo);
        }
        
        // without taking idxS-th char
        count += dfs(chsS, idxS + 1, chsT, idxT, memo);
        
        return memo[idxS][idxT] = count;
    }
}