/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl2.lc0720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach1Sorting {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> shorter = new HashSet<String>();
        String ans = "";
        for(String word : words){
            if(word.length() == 1 || shorter.contains(word.substring(0, word.length() - 1))){
                ans = word.length() > ans.length() ? word : ans;
                shorter.add(word);
            }
        }
        
        return ans;
    }
}