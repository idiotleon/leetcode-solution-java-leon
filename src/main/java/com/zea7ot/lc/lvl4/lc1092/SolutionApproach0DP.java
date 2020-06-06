/**
 * https://leetcode.com/problems/shortest-common-supersequence/
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(M * N * L)
 *  L, the length of Longest Common Subsequence
 * 
 * a bottom-up approach
 * 
 * References:
 *  https://leetcode.com/problems/shortest-common-supersequence/discuss/312710/C++Python-Find-the-LCS/434150
 *  https://leetcode.com/problems/shortest-common-supersequence/discuss/312710/C++Python-Find-the-LCS/290904
 */
package com.zea7ot.lc.lvl4.lc1092;

import java.util.Arrays;

public class SolutionApproach0DP {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] chs1 = str1.toCharArray(), chs2 = str2.toCharArray();
        char[] chs = longestCommonSubsequence(chs1, chs2).toCharArray();
        
        int i = 0, j = 0;
        StringBuilder builder = new StringBuilder();
        
        for(char c : chs){
            while(chs1[i] != c){
                builder.append(chs1[i++]);
            }
            
            while(chs2[j] != c){
                builder.append(chs2[j++]);
            }
            
            builder.append(c);
            i++;
            j++;
        }
        
        builder.append(str1.substring(i)).append(str2.substring(j));
        return builder.toString();
    }
    
    private String longestCommonSubsequence(char[] chs1, char[] chs2){
        final int M = chs1.length, N = chs2.length;
        String[][] dp = new String[M + 1][N + 1];
        for(String[] row : dp) Arrays.fill(row, "");
        
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(chs1[i - 1] == chs2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + chs1[i - 1];
                }else{
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        
        return dp[M][N];
    }
}