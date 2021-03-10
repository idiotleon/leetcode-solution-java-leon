/**
 * https://leetcode.com/problems/palindrome-pairs/
 * 
 * Time Complexity: O(N * k ^ 2)
 * Space Complexity: O(M * L)
 * 
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure
 */
package com.an7one.leetcode.lvl5.lc0336;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Trie {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(words == null || words.length == 0) return ans;
        
        // to build up the Trie
        TrieNode root = buildTrie(words);

        for(int i = 0; i < words.length; i++){
            search(words, i, root, ans);
        }
        
        return ans;
    }
    
    private void search(String[] words, int i, TrieNode node, List<List<Integer>> ans){
        String word = words[i];
        char[] chs = word.toCharArray();
        for(int j = 0; j < chs.length; j++){
            if(node.index >= 0                 
            // not the same word 
            && node.index != i 
            // is a palindrome for the rest of word
            && isPalindrome(word, j, word.length() - 1)){
                ans.add(Arrays.asList(i, node.index));
            }
                
            node = node.children[chs[j] - 'a'];
            if(node == null) return;
        }
            
        for(int j : node.indexes){
            if(i != j){
                ans.add(Arrays.asList(i, j));
             }
         }
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        
        for(int i = 0; i < words.length; i++){
            TrieNode node = root;
            String word = words[i];
            char[] chs = word.toCharArray();
            
            for(int j = word.length() - 1; j >= 0; j--){
                char c = chs[j];
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                
                if(isPalindrome(word, 0, j)){
                    node.indexes.add(i);
                }
                
                node = node.children[c - 'a'];
            }
            
            node.indexes.add(i);
            node.index = i;
        }
        
        return root;
    }
    
    
    private boolean isPalindrome(String word, int start, int end){
        char[] chs = word.toCharArray();
        while(start < end){
            if(chs[start++] != chs[end--]) return false;
        }
        
        return true;
    }
}

class TrieNode{
    /**
     * the index of the word in the words(input),
     * also to tell the difference among the same char from different words
     */
    public int index;
    /**
     * the indexes saves indices of two kinds:
     *  1. each word has a suffix represented by the current TrieNode
     *  2. the rest of the word forms a palindrome
     */
    public List<Integer> indexes;
    public final TrieNode[] children;
    
    public TrieNode(){
        this.index = -1;
        this.indexes = new ArrayList<Integer>();
        this.children = new TrieNode[26];
    }
}