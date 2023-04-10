/**
 * https://leetcode.com/problems/design-search-autocomplete-system/
 * 
 * Time Complexity:
 * Space Complexity: 
 */
package com.idiotleon.leetcode.lvl5.lc0642;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach1Trie {
    private String prefix;
    private TrieNode root;
    private TrieNode curSearchNode;

    public SolutionApproach1Trie(String[] sentences, int[] times) {
        this.prefix = "";
        this.root = new TrieNode();
        curSearchNode = root;
        for(int i = 0; i < sentences.length; i++){
            addWord(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> list = new ArrayList<String>();
        if(c == '#'){
            addWord(prefix, 1);
            prefix = "";
            curSearchNode = root;
            return list;
        }
        
        List<Pair> pairList = new ArrayList<Pair>();
        prefix += c;
        if(curSearchNode != null){
            curSearchNode = curSearchNode.children.get(c);
        }
        
        dfs(curSearchNode, pairList, prefix);
        
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>((a, b) -> (a.times != b.times ? a.times - b.times : b.str.compareTo(a.str)));
        for(Pair p : pairList){
            heap.offer(p);
            if(heap.size() > 3){ heap.poll(); }
        }
        
        while(!heap.isEmpty()){
            list.add(heap.poll().str);
        }
        
        Collections.reverse(list);
        return list;
    }
    
    private void dfs(TrieNode node, List<Pair> pairList, String prefix){
        if(node == null) return;
        if(node.times > 0){
            pairList.add(new Pair(prefix, node.times));
        }
        
        for(char c : node.children.keySet()){
            dfs(node.children.get(c), pairList, prefix + c);
        }
    }
    
    private void addWord(String word, int count){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        
        cur.times += count;
    }

    class Pair{
        public String str;
        public int times;
        public Pair(String str, int times){
            this.str = str;
            this.times = times;
        }
    }
    
    class TrieNode{
        public final Map<Character, TrieNode> children;
        public int times;
        
        public TrieNode(){
            this.children = new HashMap<Character, TrieNode>();
            this.times = 0;
        }
    }
}
