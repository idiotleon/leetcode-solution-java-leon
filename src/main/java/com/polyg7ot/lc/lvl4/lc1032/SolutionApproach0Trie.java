/**
 * https://leetcode.com/problems/stream-of-characters/
 * 
 * Time Comlexity: O(N * L) + O(Q * W)
 *  O(N * L), to build the trie
 *  O(Q * W), to perform the query, in the worst case
 * 
 * Space Complexity: O(N * L) + O(Q)
 *  O(N * L), to save the Trie
 *  O(Q * W), to save the char to history
 * 
 * References:
 *  https://leetcode.com/problems/stream-of-characters/discuss/278769/Java-Trie-Solution
 *  https://www.youtube.com/watch?v=3A98vh5zsqw
 */
package com.polyg7ot.lc.lvl4.lc1032;

public class SolutionApproach0Trie {
    private TrieNode root = null;
    private StringBuilder builder;

    public SolutionApproach0Trie(String[] words) {
        this.root = buildTrie(words);
        this.builder = new StringBuilder();
    }
    
    public boolean query(char letter) {
        builder.append(letter);
        
        TrieNode node = root;
        
        for(int i = builder.length() - 1; i >= 0 && node != null; i--){
            char ch = builder.charAt(i);
            node = node.children[ch - 'a'];
            if(node != null && node.isEnd){
                return true;
            }
        }
        
        return false;
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