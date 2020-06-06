/**
 * https://leetcode.com/problems/concatenated-words/
 * 
 * Time Complexity: O(N * L!)
 * Space Complexity: O(L)
 * 
 * References:
 *  https://leetcode.com/problems/concatenated-words/discuss/541520/Java-DFS-%2B-Memoization-Clean-code
 */
package com.zea7ot.lc.lvl5.lc0472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach1DFSwMemo {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(words == null || words.length == 0) return ans;

        Set<String> wordSet = new HashSet<String>(Arrays.asList(words));
        Map<String, Boolean> cache = new HashMap<String, Boolean>();
        
        for(String word : words){
            if(dfs(word, wordSet, cache)){
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    private boolean dfs(String word, 
                        Set<String> wordSet, 
                        Map<String, Boolean> cache){
        if(cache.containsKey(word)) return cache.get(word);
        for(int i = 1; i < word.length(); i++){
            if(wordSet.contains(word.substring(0, i))){
                String suffix = word.substring(i);
                if(wordSet.contains(suffix) || dfs(suffix, wordSet, cache)){
                    cache.put(word, true);
                    return true;
                }
            }
        }
        cache.put(word, false);
        return false;
    }
}