package com.an7one.leetcode.lvl2.lc0676;

import com.an7one.util.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/implement-magic-dictionary/">LC0676</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TrieWithDFS {
    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public SolutionApproach0TrieWithDFS() {
        this.root = new TrieNode();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(final String[] dict) {
        for (final String word : dict) {
            TrieNode node = root;
            final char[] chs = word.toCharArray();
            for (final char ch : chs) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }

                node = node.children.get(ch);
            }

            node.isEnd = true;
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after
     * modifying exactly one character
     */
    public boolean search(final String word) {
        TrieNode node = root;
        return search(word, 0, node, false);
    }

    private boolean search(final String word, final int idx, final TrieNode node, final boolean hasAnyDiff) {
        if (idx < word.length()) {
            final char[] chs = word.toCharArray();

            if (node.children.containsKey(chs[idx])) {
                if (search(word, idx + 1, node.children.get(chs[idx]), hasAnyDiff)) {
                    return true;
                }
            }

            if (!hasAnyDiff) {
                for (char ch : node.children.keySet()) {
                    if (ch != chs[idx] && search(word, idx + 1, node.children.get(ch), true)) {
                        return true;
                    }
                }
            }

            // if there is no difference till the end of the word,
            // to return false
            return false;
        }

        return hasAnyDiff && node.isEnd;
    }

    private static class TrieNode {
        private final Map<Character, TrieNode> children;
        private boolean isEnd;

        private TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }
}