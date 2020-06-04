/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Compelxity:    O(L ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution/162610
 */
package com.polyg7ot.lc.lvl4.lc0516;

public class SolutionApproach0DFSMemo {
    public int longestPalindromeSubseq(String s) {
        // sanity check
        if(s == null || s.length() == 0) return 0;
        final int L = s.length();
        Integer[][] memo = new Integer[L][L];
        return dfs(s, 0, L - 1, memo);
    }
    
    private int dfs(String str, int i, int j, Integer[][] memo){
        if(memo[i][j] != null) return memo[i][j];
        
        if(i > j) return 0;
        if(i == j) return 1;
        
        if(str.charAt(i) == str.charAt(j)){
            memo[i][j] = dfs(str, i + 1, j - 1, memo) + 2;
        }else{
            memo[i][j] = Math.max(dfs(str, i + 1, j, memo), 
                                  dfs(str, i, j - 1, memo));
        }
        
        return memo[i][j];
    }
}