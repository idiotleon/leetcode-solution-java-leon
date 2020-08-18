/**
 * https://leetcode.com/problems/palindromic-substrings/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/palindromic-substrings/discuss/105707/Java-Python-DP-solution-based-on-longest-palindromic-substring
 */
package com.zea7ot.leetcode.lvl3.lc0647;

public class SolutionApproach0DP2Dimen {
    public int countSubstrings(String str) {
        // sanity check
        if(str == null || str.isEmpty()) return 0;
        
        final int L = str.length();
        char[] chs = str.toCharArray();
        
        int count = 0;
        boolean[][] dp = new boolean[L][L];
        for(int i = L - 1; i >= 0; --i){
            for(int j = i; j < L; j++){
                dp[i][j] = chs[i] == chs[j] && (j - i + 1 < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++count;
            }
        }
        
        return count;
    }
}