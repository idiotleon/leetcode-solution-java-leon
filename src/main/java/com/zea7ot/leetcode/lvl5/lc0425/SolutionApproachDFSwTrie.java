/**
 * https://leetcode.com/problems/word-squares/
 * 
 * Time Complexity: O(N * L) + 
 * Space Complexity: O(N * L) + 
 * 
 * References:
 *  https://leetcode.com/problems/word-squares/discuss/91333/Explained.-My-Java-solution-using-Trie-126ms-1616/95910
 *  https://leetcode.com/problems/word-squares/discuss/91333/Explained.-My-Java-solution-using-Trie-126ms-1616/95925
 */
package com.zea7ot.leetcode.lvl5.lc0425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproachDFSwTrie {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanity check
        if(words == null || words.length == 0) return ans;
        final int L = words[0].length();
        
        TrieNode root = buildTrie(words);
        TrieNode[] roots = new TrieNode[L];
        Arrays.fill(roots, root);
        
        dfs(roots, new char[L][L], 0, ans);
        
        return ans;
    }
    
    private void dfs(TrieNode[] roots, 
                     char[][] intermediate, 
                     int idx, 
                     List<List<String>> ans){
        
        if(idx == intermediate.length){
            List<String> list = new ArrayList<String>(idx);
            for(char[] ca : intermediate) list.add(new String(ca));
            ans.add(list);
            return;
        }
        
        TrieNode[] nextRoots = new TrieNode[roots.length];
        for(String candidate : roots[idx].list){
            char[] chs = candidate.toCharArray();
            int i = idx;
            for(; i < intermediate.length; i++){
                char ch = chs[i];
                // to save intermediate results in intermediate(char[][])
                intermediate[idx][i] = ch;
                // to update idx-th row and col simultaneously
                if(i > idx){
                    intermediate[i][idx] = ch;
                    // early pruning if row[0,..,idx] cannot form a prefix
                    if(roots[i].children[ch - 'a'] == null) break;
                    nextRoots[i] = roots[i].children[ch - 'a'];
                }
            }
            
            if(i == intermediate.length) {
                dfs(nextRoots, intermediate, idx + 1, ans);
            }
        }
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            root.list.add(word);
            TrieNode node = root;
            char[] chs = word.toCharArray();
            for(char ch : chs){
                if(node.children[ch - 'a'] == null){
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
                node.list.add(word);
            }
        }
        
        return root;
    }
}

class TrieNode{
    public final List<String> list;
    public final TrieNode[] children;
    
    TrieNode(){
        list = new ArrayList<String>();
        children = new TrieNode[26];
    }
}