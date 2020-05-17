/**
 * https://leetcode.com/problems/index-pairs-of-a-string/
 * 
 * Time Complexity: O(N * L)
 * Space Complexity: O(N * L)
 */
package com.polyg7ot.lc.lvl3.lc1065;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Trie {
    public int[][] indexPairs(String text, String[] words) {
        if(words == null || words.length == 0 || text.isEmpty()) return new int[0][0];
        
        List<int[]> res = new ArrayList<int[]>();
        final int L = text.length();
        char[] chs = text.toCharArray();
        
        TrieNode root = buildTrie(words);
        
        for(int i = 0; i < L; i++){
            TrieNode node = root;
            char ch = chs[i];
            int j = i;
            
            while(node.children[ch - 'a'] != null){
                node = node.children[ch - 'a'];
                if(node.isEnd){
                    res.add(new int[]{i, j});
                }
                j++;
                if(j == L) break;
                else{
                    ch = chs[j];
                }
            }
        }
        
        
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        
        for(String word : words){
            TrieNode node = root;
            char[] chs = word.toCharArray();
            for(char ch : chs){
                if(node.children[ch - 'a'] == null){
                    node.children[ch - 'a'] = new TrieNode();
                }
                
                node = node.children[ch - 'a'];
            }
            
            node.isEnd = true;
        }
        
        return root;
    }
    
    private class TrieNode{
        protected TrieNode[] children;
        protected boolean isEnd;
        
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
}