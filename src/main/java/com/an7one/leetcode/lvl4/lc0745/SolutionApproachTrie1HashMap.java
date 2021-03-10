/**
 * https://leetcode.com/problems/prefix-and-suffix-search/
 * 
 * WordFilter
 *  Time Complexity: O(N * L^2)
 *  Space Complexity: O(N * L^2)
 * 
 *  N: the length of the input array
 *  L: the max length of input strings
 * 
 *  f: O(1)
 * 
 * References:
 *   https://leetcode.com/problems/prefix-and-suffix-search/discuss/110044/Three-ways-to-solve-this-problem-in-Java
 */
package com.an7one.leetcode.lvl4.lc0745;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachTrie1HashMap {
    private Map<String, Integer> wordMap = new HashMap<String, Integer>();

    public SolutionApproachTrie1HashMap(String[] words) {
        for(int k = 0; k < words.length; k++){
            for(int i = 0; i <= 10 && i <= words[k].length(); i++){
                String prefix = words[k].substring(0, i);
                for(int j = 0; j <= 10 && j <= words[k].length(); j++){
                    String suffix = words[k].substring(words[k].length() - j);
                    wordMap.put(prefix + "#" + suffix, k);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String key = prefix + "#" + suffix;
        if(wordMap.containsKey(key)){
            return wordMap.get(key);
        }
        
        return -1;
    }
}