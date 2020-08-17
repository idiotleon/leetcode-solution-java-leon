/**
 * https://leetcode.com/problems/stream-of-characters/
 * 
 * Time Complexity: O(QW)
 *  Q, number of queries
 *  W, maximum length of all words
 * 
 * Space Complexity: O(N * L) + O(W)
 *  Trie, consumes O(N * L), number of words * average length of each word
 *  Waiting list, consumes O(W), with W meaning maximum length of words
 * 
 * References:
 *  https://leetcode.com/problems/stream-of-characters/discuss/278250/Python-Trie-Solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc1032;

public class SolutionApproach0Trie1 {
    private final static int MOD = 2000;
    private TrieNode root = null;
    private int p;
    private char[] history;

    public SolutionApproach0Trie1(String[] words) {
        this.root = buildTrie(words);
        this.history = new char[MOD];
        this.p = 0;
    }
    
    public boolean query(char letter) {
        history[p % 2000] = letter;
        
        TrieNode node = root;
        boolean match = false;
        
        for(int i = 0; i < MOD && !match; i++){
            char ch = history[(p - i + MOD) % MOD];
            if(ch == 0) break;
            
            if(node.children[ch - 'a'] != null){
                node = node.children[ch - 'a'];
                if(node.isEnd) match = true;
            }else break;
        }
        
        p++;
        return match;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        
        for(String word : words){
            TrieNode node = root;
            char[] chs = word.toCharArray();
            for(int i = chs.length - 1; i >= 0; i--){
                if(node.children[chs[i] - 'a'] == null){
                    node.children[chs[i] - 'a'] = new TrieNode();
                }
                
                node = node.children[chs[i] - 'a'];
            }
            
            node.isEnd = true;
        }
        
        return root;
    }
    
    private class TrieNode{
        protected boolean isEnd;
        protected TrieNode[] children;
        
        public TrieNode(){
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
}