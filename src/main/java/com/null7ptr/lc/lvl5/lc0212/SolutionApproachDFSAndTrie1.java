/**
 * https://leetcode.com/problems/word-search-ii/
 */
package com.null7ptr.lc.lvl5.lc0212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproachDFSAndTrie1 {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private int nr, nc;
    
    public List<String> findWords(char[][] board, String[] words) {
        // sanity check
        if(board == null || board.length == 0 || words == null || words.length == 0) return new ArrayList<String>();
        
        // boundaries
        nr = board.length;
        nc = board[0].length;
        
        Set<String> result = new HashSet<String>();
        TrieNode root = buildTrie(words);
        
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                String word = "";
                dfs(board, word, root, row, col, result);
            }
        }
        
        return new ArrayList<String>(result);
    }
    
    private void dfs(char[][] board, 
                     String word, 
                     TrieNode trieNode, 
                     int row, 
                     int col, 
                     Set<String> result){
        if(row < 0 || row >= nr || col < 0 || col >= nc) return;
        
        char cur = board[row][col];
        if(cur == '#') return;
        
        trieNode = trieNode.getNext(cur);
        if(trieNode == null) return;
        
        board[row][col] = '#';
        word += cur;
        if(trieNode.isWord) result.add(word);
        for(int[] dir : DIRS){
            int r = row + dir[0], c = col + dir[1];
            dfs(board, word, trieNode, r, c, result);
        }
        board[row][col] = cur;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
        
        return root;
    }
    
    class TrieNode{
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(){}
        
        public TrieNode getNext(char c){
            return children[c - 'a'];
        }
    }
}