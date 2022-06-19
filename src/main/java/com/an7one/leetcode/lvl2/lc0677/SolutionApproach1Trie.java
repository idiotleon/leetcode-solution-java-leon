package com.an7one.leetcode.lvl2.lc0677;

import com.an7one.util.Constant;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/map-sum-pairs/">Description</a>
 *
 * Time Complexity:
 *  insert: O(L)
 *  sum:    O(L)
 *
 * Space Complexity: O(N * L * 26) + O(N) ~ O(N * L)
 *  N is the amount of words
 *  L is the average length of words
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1Trie {
    private final TrieNode root;
    private final Set<String> existingKeys;

    /** Initialize your data structure here. */
    public SolutionApproach1Trie() {
        this.root = new TrieNode(-1);
        this.existingKeys = new HashSet<>();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        char[] chs = key.toCharArray();

        for (char ch : chs) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode(val);
            } else {
                if (existingKeys.contains(key)) {
                    node.children[ch - 'a'].val = val;
                } else {
                    node.children[ch - 'a'].val += val;
                }
            }

            node = node.children[ch - 'a'];
        }
        
        existingKeys.add(key);
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        char[] chs = prefix.toCharArray();

        for (char ch : chs) {
            if (node.children[ch - 'a'] == null) return 0;

            node = node.children[ch - 'a'];
        }
        
        return node.val;
    }
    
    private static class TrieNode{
        protected int val;
        protected TrieNode[] children;
        
        public TrieNode(int val){
            this.val = val;
            this.children = new TrieNode[26];
        }
    }
}