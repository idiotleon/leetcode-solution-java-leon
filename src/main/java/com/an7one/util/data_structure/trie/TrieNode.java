package com.an7one.util.data_structure.trie;

public class TrieNode {
    private final int N = 26;

    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[N];
    public TrieNode(char c){
        TrieNode trieNode = new TrieNode(c);
        trieNode.val = c;
    }
}