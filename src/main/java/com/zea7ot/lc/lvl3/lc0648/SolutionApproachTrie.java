/**
 * https://leetcode.com/problems/replace-words/
 * 
 * Time Complexity:
 * Space Complexity:
 */
package com.zea7ot.lc.lvl3.lc0648;

import java.util.List;

public class SolutionApproachTrie {
    public String replaceWords(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        TrieNode root = buildTrie(dict);
        return replaceWords(tokens, root);
    }
    
    private String replaceWords(String[] tokens, TrieNode root){
        StringBuilder builder = new StringBuilder();
        for(String token : tokens){
            builder.append(getWordRoot(token, root));
            builder.append(" ");
        }
        
        return builder.substring(0, builder.length() - 1).toString();
    }
    
    private String getWordRoot(String token, final TrieNode root){
        TrieNode ptr = root;
        StringBuilder builder = new StringBuilder();
        char[] chs = token.toCharArray();
        for(char c : chs){
            builder.append(c);
            if(ptr.children[c - 'a'] != null){
                // *** early return ***
                if(ptr.children[c - 'a'].isWord){
                    return builder.toString();
                }
                
                ptr = ptr.children[c - 'a'];
            }else{
                return token;
            }
        }
        
        return token;
    }
    
    private TrieNode buildTrie(List<String> dict){
        TrieNode root = new TrieNode();
        for(String word : dict){
            TrieNode ptr = root;
            char[] chs = word.toCharArray();
            for(char c : chs){
                if(ptr.children[c - 'a'] == null){
                    ptr.children[c - 'a'] = new TrieNode();
                }
                ptr = ptr.children[c - 'a'];
            }
            
            ptr.isWord = true;
        }
        return root;
    }
    
    private class TrieNode{
        public final TrieNode[] children;
        public boolean isWord;
        
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}