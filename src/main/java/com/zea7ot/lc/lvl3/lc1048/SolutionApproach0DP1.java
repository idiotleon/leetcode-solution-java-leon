/**
 * https://leetcode.com/problems/longest-string-chain/
 * 
 * Time Complexity:     O(N * lg(N)) + O((N ^ 2) * L)
 *  O(N * lg(N)), consumed by sorting
 *  O(N ^ 2 * L), consumed by DP
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-string-chain/discuss/294890/C%2B%2BJavaPython-DP-Solution
 */
package com.zea7ot.lc.lvl3.lc1048;

import java.util.Arrays;

public class SolutionApproach0DP1 {
    public int longestStrChain(String[] words) {
        // sanity check
        if(words == null || words.length == 0) return 0;
        final int N = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int maxLen = 0;
        
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(words[i].length() - words[j].length() <= 1){
                    if(isPredecessor(words[j], words[i])){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
    
    private boolean isPredecessor(String str1, String str2){
        if(str1.length() == str2.length()) return false;
        char[] chs1 = str1.toCharArray(), chs2 = str2.toCharArray();
        int diff = 0, i = 0, j = 0;
        while(i < str1.length()){
            if(chs1[i] == chs2[j]){
                i++;
                j++;
            }else{
                diff++;
                if(diff > 1) return false;
                j++;
            }
        }
        
        return true;
    }
}