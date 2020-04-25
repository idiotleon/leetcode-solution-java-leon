/**
 * https://leetcode.com/problems/regular-expression-matching/
 * 
 * https://www.youtube.com/watch?v=l3hda49XcDE&t=389s
 */
package com.null7ptr.lc.lvl5.lc0010;

public class SolutionApproachDP{
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        // to deal with patterns like a* or a*b* or a*b*c*
        for(int i = 1; i < dp[0].length; i++){
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*'){
                    // 0 occurrence: dp[i][j - 2]
                    dp[i][j] = dp[i][j - 2];
                    // 1 or more occurrences: 
                    // dp[i - 1][j] if s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.'
                    // (str[i] == pattern[j - 1] || pattern[j - 1] == '.')
                    if(p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else dp[i][j] = false;
            }
        }
            
        return dp[s.length()][p.length()];
    }
}