/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
package com.zea7ot.lc.lvl4.lc0211;

public class SolutionApproach0TrieWithDFS {
    private TrieNode root;

    /** Initialize your data structure here. */
    public SolutionApproach0TrieWithDFS() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        
        node.isEndOfWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    private boolean dfs(String word, int start, TrieNode node){
        if(start == word.length()) return node.isEndOfWord;
        char c = word.charAt(start);
        if(c != '.'){
            TrieNode next = node.children[c - 'a'];
            if(next == null) return false;
            return dfs(word, start + 1, next);
        }else{
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    if(dfs(word, start + 1, node.children[i])){
                        return true;
                    };
                }
            }
        }
        
        return false;
    }

    private class TrieNode{
        protected boolean isEndOfWord;
        protected final TrieNode[] children;
        protected TrieNode(){
            children = new TrieNode[26];
        }
    }
}

