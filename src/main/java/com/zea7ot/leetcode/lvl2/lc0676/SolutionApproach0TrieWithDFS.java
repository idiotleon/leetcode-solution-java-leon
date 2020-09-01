/**
 * https://leetcode.com/problems/implement-magic-dictionary/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl2.lc0676;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0TrieWithDFS {
    private TrieNode root;

    /** Initialize your data structure here. */
    public SolutionApproach0TrieWithDFS() {
        this.root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            TrieNode node = root;
            char[] chs = word.toCharArray();
            for (char ch : chs) {
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
    public boolean search(String word) {
        TrieNode node = root;
        return search(word, 0, node, false);
    }

    private boolean search(String word, int idx, TrieNode node, boolean hasAnyDiff) {
        if (idx < word.length()) {
            char[] chs = word.toCharArray();

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

    private class TrieNode {
        protected Map<Character, TrieNode> children;
        protected boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.isEnd = false;
        }
    }
}