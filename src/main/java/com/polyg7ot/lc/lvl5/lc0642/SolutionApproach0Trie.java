/**
 * https://leetcode.com/problems/design-search-autocomplete-system/
 * 
 * Time Complexity:
 * Space Complexity:
 */
package com.polyg7ot.lc.lvl5.lc0642;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0Trie {
    private TrieNode root;
    private TrieNode cur;
    private StringBuilder builder;

    public SolutionApproach0Trie(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        builder = new StringBuilder();
        
        for(int i = 0; i < times.length; i++){
            add(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> ans = new ArrayList<String>();
        if(c == '#'){
            add(builder.toString(), 1);
            builder = new StringBuilder();
            cur = root;
            return ans;
        }
        
        builder.append(c);
        if(cur != null){
            cur = cur.children[c];
        }
        
        if(cur == null) return ans;
        for(TrieNode node : cur.hot){
            ans.add(node.str);
        }
        
        return ans;
    }
    
    private void add(String sentence, int t){
        TrieNode node = root;
        
        List<TrieNode> visited = new ArrayList<TrieNode>();
        char[] chs = sentence.toCharArray();
        for(char c : chs){
            if(node.children[c] == null){
                node.children[c] = new TrieNode();
            }
            
            node = node.children[c];
            visited.add(node);
        }
        
        node.str = sentence;
        node.times += t;
        
        for(TrieNode n : visited){
            n.update(node);
        }
    }
    
    class TrieNode implements Comparable<TrieNode>{
        TrieNode[] children;
        String str;
        int times;
        List<TrieNode> hot;
        
        public TrieNode(){
            this.children = new TrieNode[128];
            this.str = null;
            this.times = 0;
            this.hot = new ArrayList<TrieNode>();
        }
        
        @Override
        public int compareTo(TrieNode o){
            if(this.times == o.times){
                return this.str.compareTo(o.str);
            }
            
            return o.times - this.times;
        }
        
        public void update(TrieNode node){
            if(!this.hot.contains(node)){
                this.hot.add(node);
            }
            
            Collections.sort(hot);
            
            if(hot.size() > 3){
                hot.remove(hot.size() - 1);
            }
        }
    }
}