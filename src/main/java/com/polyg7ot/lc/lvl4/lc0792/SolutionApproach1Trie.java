/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 * 
 * Time Complexity: O(N * L) + O(N * L)
 * 
 * Space Complexity: O(N * L) + O(L) ~ O(N * L)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-matching-subsequences/discuss/157065/Java-Trie-Solution
 */
package com.polyg7ot.lc.lvl4.lc0792;

public class SolutionApproach1Trie {
    public int numMatchingSubseq(String str, String[] words) {
        if(words == null || words.length == 0) return 0;
        TrieNode root = buildTrie(words);
        return dfs(root, str, 0);
    }
    
    private int dfs(TrieNode node, String str, int pos){
        if(node == null) return 0;
        int index = str.indexOf(node.ch, pos);
        if(node.ch != '#' && index == -1) return 0;
        
        int ans = node.endCnt;
        for(int i = 0; i < 26; i++){
            ans += dfs(node.children[i], str, node.ch == '*' ? 0 : index + 1);
        }
        return ans;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode('#');
        
        for(String word : words){
            TrieNode node = root;
            
            for(char ch : word.toCharArray()){
                if(node.children[ch - 'a'] == null){
                    node.children[ch - 'a'] = new TrieNode(ch);
                }
                
                node = node.children[ch - 'a'];
            }
            
            ++node.endCnt;
        }
        
        return root;
    }
    
    private class TrieNode{
        protected char ch;
        protected int endCnt;
        protected TrieNode[] children;
        
        public TrieNode(char ch){
            this.ch = ch;
            this.endCnt = 0;
            this.children = new TrieNode[26];
        }
    }
}