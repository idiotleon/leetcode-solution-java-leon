/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
package com.zea7ot.leetcode.lvl4.lc0126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproachTwoEndsBFS {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return new ArrayList<List<String>>();
        
        // hash set for both ends
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        
        // to initialize words in both ends
        set1.add(beginWord);
        set2.add(endWord);
        
        // to help construct the final result
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        // to build up the map
        helper(new HashSet<String>(wordList), set1, set2, map, false);
        
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>(Arrays.asList(beginWord));
        
        // to recursively build the final result
        generateList(beginWord, endWord, map, sol, res);
        
        return res;
    }
    
    private boolean helper(Set<String> dict, 
                        Set<String> set1, 
                        Set<String> set2, 
                        Map<String, List<String>> map, 
                        boolean flip){
        if(set1.isEmpty()) return false;
        
        if(set1.size() > set2.size()) return helper(dict, set2, set1, map, !flip);
        
        // to remove words on current both ends from the dict
        dict.removeAll(set1);
        dict.removeAll(set2);
        
        // as we only need the shortest paths
        // we use a boolean value to help with early termination
        boolean done = false;
        
        // set for the next level
        Set<String> set = new HashSet<String>();
        
        // for each string in end1
        for(String str : set1){
            for(int i = 0; i < str.length(); i++){
                char[] chs = str.toCharArray();
                
                // to change one character for every position
                for(char ch = 'a'; ch <= 'z'; ch++){
                    chs[i] = ch;
                    
                    String word = String.valueOf(chs);
                    
                    // to make sure we construct the tree in the correct direction
                    String key = flip ? word : str;
                    String val = flip ? str : word;
                    
                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
                    
                    if(set2.contains(word)){
                        done = true;
                        
                        list.add(val);
                        map.put(key, list);
                    }
                    
                    if(!done && dict.contains(word)){
                        set.add(word);
                        
                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }
        
        // to early terminate the recursion if "done" is true
        return done || helper(dict, set2, set, map, !flip);
    }
    
    private void generateList(String start, 
                              String end, 
                              Map<String, List<String>> map, 
                              List<String> sol, 
                              List<List<String>> res){
        if(start.equals(end)){
            res.add(new ArrayList<String>(sol));
            return;
        }
        
        // to check in case the difference between start and end happens to be one
        // e.g.: "a", "c", {"a", "b", "c"}
        if(!map.containsKey(start)) return;
        
        for(String word : map.get(start)){
            sol.add(word);
            generateList(word, end, map, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}