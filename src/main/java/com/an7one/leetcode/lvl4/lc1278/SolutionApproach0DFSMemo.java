/**
 * https://leetcode.com/problems/palindrome-partitioning-iii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-partitioning-iii/discuss/441427/Python3-Top-down-DFS-with-Memoization/520599
 */
package com.an7one.leetcode.lvl4.lc1278;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSMemo {
    public int palindromePartition(String s, int K) {
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return dfs(0, K, s, memo);
    }
    
    private int dfs(int idxStart, int k, String str, Map<String, Integer> memo){
        final int L = str.length();
        
        String key = idxStart + "$" + k;
        if(memo.containsKey(key)) return memo.get(key);
        
        if(L - idxStart == k) return 0;
        if(k == 1) return getCost(idxStart, L - 1, str);
        
        int res = Integer.MAX_VALUE;
        for(int i = idxStart + 1; i <= L - k + 1; ++i){
            res = Math.min(res, dfs(i, k - 1, str, memo) + getCost(idxStart, i - 1, str));
        }
        
        memo.put(key, res);
        return res;
    }
    
    private int getCost(int lo, int hi, String str){
        int cost = 0;
        char[] chs = str.toCharArray();
        while(lo < hi){
            if(chs[lo++] != chs[hi--]){
                ++cost;
            }
        }
        
        return cost;
    }
}