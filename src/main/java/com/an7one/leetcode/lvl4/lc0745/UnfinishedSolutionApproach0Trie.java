/**
 * https://leetcode.com/problems/prefix-and-suffix-search/
 * 
 * 
 */
package com.an7one.leetcode.lvl4.lc0745;

import java.util.HashMap;
import java.util.Map;

public class UnfinishedSolutionApproach0Trie {
    private TrieNode root;
    private int N;

    public UnfinishedSolutionApproach0Trie(String[] words) {
        this.root = new TrieNode("");
        this.N = words.length;
        
        for(int i = 0; i < words.length; i++){
            TrieNode node = root;
            String word = words[i];
            char[] chs = word.toCharArray();
            for(int j = 0; j < chs.length; j++){
                char ch = chs[j];
                if(!node.children.containsKey(ch)){
                    node.children.put(ch, new TrieNode(word.substring(j)));
                }
                
                node = node.children.get(ch);
            }
            
            node.weight = i;
            node.isEnd = true;
        }
    }
    
    public int f(String prefix, String suffix) {
        if(prefix.isEmpty() && suffix.isEmpty()) return N;
        
        // if(suffix.isEmpty()) return dfs(root, prefix, 0, "", true);
        return dfs(root, prefix, 0, suffix, false);
    }
    
    private int dfs(TrieNode node,
                    String prefix,
                    int idx,
                    String suffix, 
                    boolean suffixMatched){
        
        int ans = Integer.MIN_VALUE;
        
        if(suffix.isEmpty() || node.suffix.equals(suffix)){
            suffixMatched = true;
        }

        if(node.isEnd){
            if(suffixMatched){
                return node.weight;
            }else{
                return -1;
            }
        }
        
        for(Character child : node.children.keySet()){
            if(idx < prefix.length()){
                if(!node.children.containsKey(prefix.charAt(idx))) return -1;
            }
            
            ans = Math.max(ans, dfs(node.children.get(child), prefix, idx + 1, suffix, suffixMatched));
        }
        
        return ans;
    }
    
    private class TrieNode{
        protected int weight;
        protected String suffix;
        protected boolean isEnd;
        protected Map<Character, TrieNode> children;
        
        public TrieNode(int weight, String suffix){
            this.weight = weight;
            this.suffix = suffix;
            this.isEnd = false;
            this.children = new HashMap<Character, TrieNode>();
        }
        
        public TrieNode(String suffix){
            this(-1, suffix);
        }
    }
}