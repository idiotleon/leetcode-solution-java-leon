/**
 * https://leetcode.com/problems/sentence-similarity-ii/
 * 
 * Time Complexity: O(pairs.size() + 2 * words1.length * pairs.size() * lg(pairs.size())) ~ O(words1.length * pairs.size() * lg(pairs.size()) )
 * Space Complexity: O(pairs.size())
 * 
 * References:
 *  https://leetcode.com/problems/sentence-similarity-ii/discuss/109752/JavaC%2B%2B-Clean-Code-with-Explanation
 */
package com.polyg7ot.lc.lvl3.lc0737;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0UnionFind {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;
        
        Map<String, String> roots = new HashMap<String, String>();
        for(List<String> pair : pairs){
            String root1 = find(roots, pair.get(0)), root2 = find(roots, pair.get(1));
            if(!root1.equals(root2)) roots.put(root1, root2);
        }
        
        for(int i = 0; i < words1.length; i++){
            if(!words1[i].equals(words2[i])  
               && !find(roots, words1[i]).equals(find(roots, words2[i]))){
                return false;
            }
        }
        
        return true;
    }

    private String findWithPathCompression(Map<String, String> roots, String word){
        if(!roots.containsKey(word)){
            roots.put(word, word);
            return word;
        }
        
        while(!roots.get(word).equals(word)){
            if(roots.containsKey(roots.get(word))){
                // path compression
                roots.put(word, roots.get(word));   
            }
            word = roots.get(word); 
        }
        
        return word;
    }
    
    private String find(Map<String, String> roots, String word){
        if(!roots.containsKey(word)) 
            roots.put(word, word);
        return word.equals(roots.get(word)) ? word: find(roots, roots.get(word));
    }
}