/**
 * https://leetcode.com/problems/stream-of-characters/
 * 
 * Time Comlexities:
 *  constructing:   O(N * L), to build the trie
 *  `query`:        O(Q * W), to perform the query, in the worst case
 * 
 * Space Complexity: O(N * L) + O(Q)
 *  O(N * L), to save the Trie
 *  O(Q * W), to save the char to history
 *      W, the maximum length among all words
 *      Q, the number of calls of `query()`
 * 
 * References:
 *  https://leetcode.com/problems/stream-of-characters/discuss/278769/Java-Trie-Solution
 *  https://www.youtube.com/watch?v=3A98vh5zsqw
 */
package com.zea7ot.leetcode.ood.lvl4.lc1032;

public class SolutionApproach0Trie {
    private TrieNode root;
    private StringBuilder builder;

    public SolutionApproach0Trie(String[] words) {
        this.root = buildTrie(words);
        this.builder = new StringBuilder();
    }

    public boolean query(char letter) {
        builder.append(letter);
        final int L = builder.length();

        TrieNode cur = root;
        for (int i = L - 1; i >= 0 && cur != null; --i) {
            char ch = builder.charAt(i);
            cur = cur.children[ch - 'a'];
            if (cur != null && cur.isEnd)
                return true;
        }

        return false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            final int L = word.length();
            char[] chs = word.toCharArray();

            TrieNode cur = root;
            for (int i = L - 1; i >= 0; --i) {
                int idx = chs[i] - 'a';
                if (cur.children[idx] == null)
                    cur.children[idx] = new TrieNode();

                cur = cur.children[idx];
            }

            cur.isEnd = true;
        }

        return root;
    }

    private class TrieNode {
        protected boolean isEnd;
        protected TrieNode[] children;

        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
}