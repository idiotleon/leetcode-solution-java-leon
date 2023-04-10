/**
 * https://leetcode.com/problems/concatenated-words/
 * 
 * Time Complexity: O(N * L!)
 * Space Complexity: O(L)
 * 
 * References:
 *  https://leetcode.com/problems/concatenated-words/discuss/541520/Java-DFS-%2B-Memoization-Clean-code
 */
package com.idiotleon.leetcode.lvl5.lc0472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach1DFSwMemo1 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(words == null || words.length == 0) return ans;
        
        Set<String> wordSet = new HashSet<String>(Arrays.asList(words));
        Set<String> failure = new HashSet<String>();
        
        for(String word : words){
            if(dfs(word, wordSet, failure)){
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    private boolean dfs(String word, 
                        Set<String> wordSet, 
                        Set<String> failure){
        if(failure.contains(word)) return false;

        for(int i = 1; i < word.length(); i++){
            if(wordSet.contains(word.substring(0, i))){
                String suffix = word.substring(i);
                if(wordSet.contains(suffix) 
                   || dfs(suffix, wordSet, failure)){
                    return true;
                }
            }
        }
        
        failure.add(word);
        return false;
    }
}