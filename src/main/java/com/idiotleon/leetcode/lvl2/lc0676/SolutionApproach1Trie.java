package com.idiotleon.leetcode.lvl2.lc0676;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/implement-magic-dictionary/">LC0676</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1Trie {
    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public SolutionApproach1Trie() {
        root = new TrieNode();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            TrieNode node = root;
            final char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char ch = chs[i];
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }

                node = node.children[ch - 'a'];
            }

            node.isEnd = true;
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < 26; j++) {
                char ch = (char) (j + 'a');
                if (ch == chs[i]) continue;
                char temp = chs[i];
                chs[i] = ch;
                if (find(String.valueOf(chs))) return true;
                chs[i] = temp;
            }
        }

        return false;
    }

    private boolean find(String word) {
        TrieNode node = root;
        char[] chs = word.toCharArray();
        for (char ch : chs) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }

            node = node.children[ch - 'a'];
        }

        return node.isEnd;
    }

    private static class TrieNode {
        private final TrieNode[] children;
        private boolean isEnd;

        private TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
}