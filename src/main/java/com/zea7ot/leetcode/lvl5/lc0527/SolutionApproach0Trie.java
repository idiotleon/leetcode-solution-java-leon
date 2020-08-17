/**
 * https://leetcode.com/problems/word-abbreviation/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:  
 *  https://leetcode.com/problems/word-abbreviation/discuss/99792/HashMap-%2B-Trie-greater-O(nL)-solution
 */
package com.zea7ot.leetcode.lvl5.lc0527;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0Trie {
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<Integer>> abbrMap = new HashMap<String, List<Integer>>();
        
        List<String> res = new ArrayList<String>(Collections.nCopies(dict.size(), null));
        for(int i = 0; i < dict.size(); i++){
            String word = dict.get(i);
            String str = getShortestAbbr(word);
            List<Integer> indexes = abbrMap.get(str);
            if(indexes == null){
                indexes = new ArrayList<Integer>();
                abbrMap.put(str, indexes);
            }
            indexes.add(i);
        }
        
        for(Map.Entry<String, List<Integer>> entry : abbrMap.entrySet()){
            String abbr = entry.getKey();
            List<Integer> indexes = entry.getValue();
            resolve(dict, res, abbr, indexes);
        }
        
        return res;
    }
    
    private void resolve(List<String> dict, List<String> res, String abbr, List<Integer> indexes){
        if(indexes.isEmpty()) res.set(indexes.get(0), abbr);
        else{
            TrieNode root = buildTrie(dict, indexes);
            for(int idx : indexes){
                String word = dict.get(idx);
                TrieNode cur = root;
                int i = 0;
                final int L = word.length();
                while(i < L && cur.children.get(word.charAt(i)).count > 1){
                    cur = cur.children.get(word.charAt(i));
                    i++;
                }
                
                if(i >= L - 3){
                    res.set(idx, word);
                }else{
                    String prev = word.substring(0, i + 1);
                    String str = prev + (L - i - 2) + "" + word.charAt(L - 1);
                    res.set(idx, str);
                }
            }
        }
    }
    
    private String getShortestAbbr(String str){
        if(str.length() <= 3) return str;
        else 
            return str.charAt(0) + "" + (str.length() - 2) + "" + str.charAt(str.length() - 1);
    }
    
    private TrieNode buildTrie(List<String> dict, List<Integer> indexes){
        TrieNode root = new TrieNode();
        for(int idx : indexes){
            String word = dict.get(idx);
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(cur.children.containsKey(ch)){
                    cur = cur.children.get(ch);
                }else{
                    TrieNode child = new TrieNode();
                    cur.children.put(ch, child);
                    cur = child;
                }
                cur.count++;
            }
        }
        
        return root;
    }
    
    private class TrieNode{
        private int count;
        private Map<Character, TrieNode> children;
        
        protected TrieNode(){
            this.count = 0;
            this.children = new HashMap<Character, TrieNode>();
        }
    }
}