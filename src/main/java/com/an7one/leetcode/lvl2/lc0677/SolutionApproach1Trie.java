/**
 * https://leetcode.com/problems/map-sum-pairs/
 * 
 * Time Complexity: 
 *  insert: O(L)
 *  sum:    O(L)
 * 
 * Space Complexity: O(N * L * 26) + O(N) ~ O(N * L)
 *  N is the amount of words
 *  L is the average length of words
 */
package com.an7one.leetcode.lvl2.lc0677;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach1Trie {
    private TrieNode root;
    private Set<String> existingKeys;

    /** Initialize your data structure here. */
    public SolutionApproach1Trie() {
        this.root = new TrieNode(-1);
        this.existingKeys = new HashSet<String>();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        char[] chs = key.toCharArray();
        
        for(int i = 0; i < chs.length; i++){
            if(node.children[chs[i] - 'a'] == null){
                node.children[chs[i] - 'a'] = new TrieNode(val);
            }else{
                if(existingKeys.contains(key)){
                    node.children[chs[i] - 'a'].val = val;
                }else{
                    node.children[chs[i] - 'a'].val += val;
                }
            }
            
            node = node.children[chs[i] - 'a'];
        }
        
        existingKeys.add(key);
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        char[] chs = prefix.toCharArray();
        
        for(int i = 0; i < chs.length; i++){
            if(node.children[chs[i] - 'a'] == null) return 0;
            
            node = node.children[chs[i] - 'a'];
        }
        
        return node.val;
    }
    
    private class TrieNode{
        protected int val;
        protected TrieNode[] children;
        
        public TrieNode(int val){
            this.val = val;
            this.children = new TrieNode[26];
        }
    }
}