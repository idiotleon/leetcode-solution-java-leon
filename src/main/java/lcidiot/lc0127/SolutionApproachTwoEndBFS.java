/**
 * https://leetcode.com/problems/word-ladder/
 */
package main.java.lcidiot.lc0127;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        Set<String> set1 = new HashSet<String>();
        set1.add(beginWord);
        
        Set<String> set2 = new HashSet<String>();
        set2.add(endWord);
        
        return helper(new HashSet<String>(wordList), set1, set2, 1);
    }
    
    private int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level){
        if(set1.isEmpty()) return 0;
        
        if(set1.size() > set2.size()) return helper(dict, set2, set1, level);
        
        // to remove words from both ends
        for(String word : set1) dict.remove(word);
        // equivalent
        // dict.removeAll(set1);
        for(String word : set2) dict.remove(word);
        // equivalent
        // dict.removeAll(set2);
        
        // the set for the next level
        Set<String> set = new HashSet<String>();
        
        // for each string in the current level
        for(String str : set1)
            for(int i = 0; i < str.length(); i++){
                char[] chs = str.toCharArray();
                
                // to change the letter at every position
                for(char ch = 'a'; ch <= 'z'; ch++){
                    chs[i] = ch;
                    String word = String.valueOf(chs);
                    
                    // found the word in other end(set)
                    if(set2.contains(word)) return level + 1;
                    
                    // if not, add it to the next level
                    if(dict.contains(word)) set.add(word);
                }
            }
        
        return helper(dict, set2, set, level + 1);
    }
}