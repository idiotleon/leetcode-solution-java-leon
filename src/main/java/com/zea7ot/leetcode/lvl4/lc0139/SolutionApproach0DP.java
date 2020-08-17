/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/44054/Java-DP-solution
 */
package com.zea7ot.leetcode.lvl4.lc0139;

import java.util.List;

public class SolutionApproach0DP {
    public boolean wordBreak(String str, List<String> wordDict) {
        if(str == null || str.length() == 0) return false;
        
        boolean[] dp = new boolean[str.length()];
        
        for(int i = 0; i < str.length(); i++)
            for(int j = 0; j <= i; j++)
                /*
                * why "if(j == 0 || dp[j - 1])"?
                * https://leetcode.com/problems/word-break/discuss/44054/Java-DP-solution/251191
                * The for loop is looking at ranges or substrings. 
                * If we know that the current substring is in the dictionary AND the substring before it is also in the dictionary then we know that the str.substring(0, i) is true. 
                * j == 0 because the first substring has nothing before it (dp[j- 1] does not exist).
                * ------- left substring ---- | substring (j, i + 1) | -------right substring ------ |
                * If we know that str.substring(j,i+1) is in the dictionary, we can only mark it true if the left substring is also in the dictionary.
                * 
                * Then, for the right substring, it is str.substring(i + 1, end). 
                * You can only mark dp[end] is true if you know the substring up to i are in dictionary.
                * This is what makes this a dynamic programming solution.
                */
                if(j == 0 || dp[j - 1]){
                    String sub = str.substring(j, i + 1);
                    if(wordDict.contains(sub)) dp[i] = true;
                }
        
        return dp[str.length() - 1];
    }


public boolean wordBreak2(String str, List<String> wordDict) {
    if(str == null || str.length() == 0) return false;
        
    final int N = str.length();
    // dp[i] represents whether s[0...i] can be formed by dict
    boolean[] dp = new boolean[N];
        
    for(int i = 0; i < N; i++)
        for(int j = 0; j <= i; j++){
            String sub = str.substring(j, i + 1);
                
            if(wordDict.contains(sub) && (j == 0 || dp[j - 1])){
                dp[i] = true;
                break;
            }
        }
        
        return dp[N - 1];
    }
}