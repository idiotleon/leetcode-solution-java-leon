package com.an7one.leetcode.lvl2.lc0677;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/map-sum-pairs/">LC0677</a>
 * <p>
 * Time Complexity:
 * insert: O(L), where L is the actual length of the word to be inserted
 * sum:    O(L), where L is the longest branch for that prefix of the Trie
 * <p>
 * Space Complexity:    O(N * L * 26) + O(L) ~ O(N * L)
 * Trie:       O(N * L * 26)
 * Call stack: O(L)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Trie {
    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public SolutionApproach0Trie() {
        this.root = new TrieNode(-1);
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        final char[] chs = key.toCharArray();

        for (char ch : chs) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }

            node = node.children[ch - 'a'];
        }

        node.isEnd = true;
        node.val = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        final char[] chs = prefix.toCharArray();

        for (char ch : chs) {
            if (node.children[ch - 'a'] == null) return 0;

            node = node.children[ch - 'a'];
        }

        return dfs(node);
    }

    // dfs to the end of the end of that branch of Trie
    private int dfs(TrieNode node) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                sum += dfs(node.children[i]);
            }
        }

        return sum + node.val;
    }

    private static class TrieNode {
        private int val;
        private final TrieNode[] children;
        private boolean isEnd;

        private TrieNode() {
            this.val = 0;
            this.children = new TrieNode[26];
            this.isEnd = false;
        }

        private TrieNode(int val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
}