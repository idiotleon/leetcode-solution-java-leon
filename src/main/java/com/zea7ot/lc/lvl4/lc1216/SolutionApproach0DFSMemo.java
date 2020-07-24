/**
 * https://leetcode.com/problems/valid-palindrome-iii/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O()
 */
package com.zea7ot.lc.lvl4.lc1216;

public class SolutionApproach0DFSMemo {
    public boolean isValidPalindrome(String s, int k) {
        // sanity check
        if(s == null || s.isEmpty() || k <= 0) return false;
        final int L = s.length();
        Integer[][] memo = new Integer[L][L];
        return L - dfs(0, L - 1, s, memo) <= k;
    }
    
    private int dfs(int i, int j, String str, Integer[][] memo){
        if(memo[i][j] != null) return memo[i][j];
        
        if(i > j) return 0;
        if(i == j) return 1;
        
        if(str.charAt(i) == str.charAt(j)){
            memo[i][j] = dfs(i + 1, j - 1, str, memo) + 2;
        }else{
            memo[i][j] = Math.max(dfs(i + 1, j, str, memo), 
                                  dfs(i, j - 1, str, memo));
        }
        
        return memo[i][j];
    }
}