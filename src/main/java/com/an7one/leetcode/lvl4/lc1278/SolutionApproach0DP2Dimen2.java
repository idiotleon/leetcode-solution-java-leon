/**
 * https://leetcode.com/problems/palindrome-partitioning-iii/
 * 
 * Time Complexity:     O((L ^ 2) * K)
 * Space Complexity:    O(L ^ 2)
 * 
 * `dp[k][len]`, minimal number of changes, i.e. costs, if one partition the substring `s[0 : len]` into `k` parts
 * 
 * Transition:
 *  dp[k][len] = dp[k - 1][sub] + costs of s.substring(sub + 1, len)
 *  (i.e., dp[parts][right] = dp[parts - 1][left] + costs of s.substring(left + 1, right))
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-partitioning-iii/discuss/442789/Java-4ms-DP-with-memorization-+-explanation/399030
 *  https://leetcode.com/problems/palindrome-partitioning-iii/discuss/442789/Java-4ms-DP-with-memorization-%2B-explanation
 */
package com.an7one.leetcode.lvl4.lc1278;

public class SolutionApproach0DP2Dimen2 {
    public int palindromePartition(String s, int K) {
        final int L = s.length();
        if(L <= K) return 0;
        
        int[][] memo = new int[L][L];
        for(int i = 0; i < L; ++i){
            for(int j = i; j < L; ++j){
                memo[i][j] = -1;
            }
        }
        
        char[] chs = s.toCharArray();
        int[][] dp = new int[K][L];
        
        for(int k = 0; k < K; ++k){
            for(int len = k; len < L; ++len){
                if(k == 0){
                    dp[k][len] = getCost(k, len, chs, memo);
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int sub = k; sub <= len; ++sub){
                        min = Math.min(min, dp[k - 1][sub - 1] + getCost(sub, len, chs, memo));
                    }
                
                    dp[k][len] = min;
                }
            }
        }
        
        return dp[K - 1][L - 1];
    }
    
    private int getCost(int lo, int hi, char[] chs, int[][] memo){
        if(memo[lo][hi] != -1) return memo[lo][hi];
        
        int diff = 0, left = lo, right = hi;
        while(left < right){
            if(chs[left++] != chs[right--]) ++diff;
        }
        
        return memo[lo][hi] = diff;
    }
}