/**
 * https://leetcode.com/problems/word-search-ii/
 * 
 * https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
 */
package main.java.lcidiot.lc.lvl5.lc0212;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFSAndTrie {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int nr, nc;
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(board == null || board.length == 0 || words == null || words.length == 0) return ans;
        
        // boundaries of char[][] board
        nr = board.length;
        nc = board[0].length;
        
        TrieNode root = buildTrie(words);
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                dfs(board, root, row, col, ans);
            }
        }
        
        return ans;
    }
    
    private void dfs(char[][] board,
                     TrieNode node, 
                     int row, 
                     int col, 
                     List<String> res){
        if(row < 0 || row >= nr || col < 0 || col >= nc) return;
        
        char cur = board[row][col];
        if(cur == '#' || node.children[cur - 'a'] == null) return;
        
        node = node.children[cur - 'a'];
        if(node.word != null){  // found one
            res.add(node.word);
            node.word = null;   // de-duplicate
        }
        

        // to backtrack
        board[row][col] = '#';
        for(int[] dir : DIRS){
            int r = row + dir[0], c = col + dir[1];
            dfs(board, node, r, c, res);
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
            node.word = word;
        }
        
        return root;
    }
    
    class TrieNode{
        public String word;
        public TrieNode[] children = new TrieNode[26];
    }
}