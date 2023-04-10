package com.idiotleon.leetcode.lvl2.lc0720;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/longest-word-in-dictionary/">LC0720</a>
 * <p>
 * Time Complexity: O(N * L) + O(N * L) ~ O(N * L)
 * O(N * L), to build up the Trie
 * O(N * L), to DFS the Trie
 * <p>
 * Space Complexity: O(N * L) + O(H)
 * O(N * L), for the Trie
 * O(H), for the call stacks of DFS
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSWithTrie {
    public String longestWord(String[] words) {
        // sanity check
        if (words == null || words.length == 0) return "";

        final TrieNode root = buildTrie(words);
        return dfs(root);
    }

    private String dfs(final TrieNode node) {
        String ans = node.word;
        for (TrieNode child : node.children) {
            if (child != null && !child.word.isEmpty()) {
                String childWord = dfs(child);
                if (childWord.length() > ans.length()
                        || (childWord.length() == ans.length() && childWord.compareTo(ans) < 0)) {
                    ans = childWord;
                }
            }
        }

        return ans;
    }

    private TrieNode buildTrie(final String[] words) {
        final TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            final char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (node.children[chs[i] - 'a'] == null) {
                    node.children[chs[i] - 'a'] = new TrieNode();
                }

                node = node.children[chs[i] - 'a'];
            }

            node.word = word;
        }

        return root;
    }

    private static class TrieNode {
        private String word;
        private final TrieNode[] children;

        private TrieNode() {
            this.word = "";
            this.children = new TrieNode[26];
        }
    }
}