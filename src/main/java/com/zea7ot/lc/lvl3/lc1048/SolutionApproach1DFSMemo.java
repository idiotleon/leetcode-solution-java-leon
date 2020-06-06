/**
 * https://leetcode.com/problems/longest-string-chain/
 * 
 * Time Complexity:     O(N) + O()
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/longest-string-chain/discuss/294890/C++JavaPython-DP-Solution/277824
 */
package com.zea7ot.lc.lvl3.lc1048;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach1DFSMemo {
    public int longestStrChain(String[] words) {
        // sanity check
        if(words == null || words.length == 0) return 0;
        
        Set<String> wordSet = new HashSet<String>();
        Map<String, Integer> memo = new HashMap<String, Integer>();
        for(String word : words) wordSet.add(word);
        
        int ans = 0;
        for(String word : words) {
            ans = Math.max(ans, dfs(wordSet, word, memo));
        }
        
        return ans;
    }
    
    private int dfs(Set<String> words, 
                    String word, 
                    Map<String, Integer> memo){
        if(memo.containsKey(word)) return memo.get(word);
        
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            String next = word.substring(0, i) + word.substring(i + 1);
            if(words.contains(next)){
                count = Math.max(count, dfs(words, next, memo));
            }
        }
        
        memo.put(word, 1 + count);
        return 1 + count;
    }
}