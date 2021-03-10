/**
 * https://leetcode.com/problems/concatenated-words/
 * 
 * Time Complexity: O(N * L!)
 *  N, the amount of words
 *  L, the length of the word
 * Space Complexity: O(N) + O(N)
 *  N, the words set
 *  N, the call stack
 */
package com.an7one.leetcode.lvl5.lc0472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach2DFS {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<String>();
        Set<String> allWords = new HashSet<String>(Arrays.asList(words));
        
        for(int i = 0; i < words.length; i++){
            if(dfs(words[i], 0, 0, allWords)){
                ans.add(words[i]);
            };
        }
        
        return ans;
    }
    
    private boolean dfs(String word, 
                        int start, 
                        int n, 
                        Set<String> allWords){
        if(start == word.length() && n > 1) return true;
        else if(start == word.length() && n == 1) return false;
        
        for(int i = start + 1; i <= word.length(); i++){
            String suffix = word.substring(start, i);
            if(allWords.contains(suffix)){
                if(dfs(word, i, n + 1, allWords)){
                    return true;
                }
            }
        }
        
        return false;
    }
}