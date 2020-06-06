/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 * Time Complexities:
 *  to construct the Trie tree: O(26 * N * L) ~ O(N * L)
 *      N is the number of words
 *      L is the average length of words
 *      26 is the total length of all alphabet letters
 *  to insert a word into the Trie tree: O(L)
 *      L is the length of the words to be inserted
 *  to search a word from the Trie tree: O(L)
 *      L is the length of the words to be searched
 *  to search the prefix of a word from the Trie tree: O(L)
 *      L is the length of the prefix to be searched
 *
 * Space Complexity:
 *  the trie Tree: O(26 * N * L) ~ O(N * L)
 *      N is the enumber of words
 *      L is the average length of words
 *      26 is the total length of all aphabet letters
 *
 * References:
 *  https://www.geeksforgeeks.org/trie-insert-and-search/
 */
package com.polyg7ot.lc.lvl3.lc0208;

public class SolutionApproach0Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public SolutionApproach0Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        
        return node.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        
        return true;
    }
}

class TrieNode{
    public boolean isEndOfWord;
    public final TrieNode[] children;
    public TrieNode(){
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}