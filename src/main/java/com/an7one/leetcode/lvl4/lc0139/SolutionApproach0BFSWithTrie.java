/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/378192/Trie-%2B-BFS-1ms-with-99.68-time-and-94-memory
 *  https://leetcode.com/problems/word-break/discuss/378192/Trie-+-BFS-1ms-with-99.68-time-and-94-memory/343116
 */
package com.an7one.leetcode.lvl4.lc0139;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0BFSWithTrie {
    public boolean wordBreak(String s, List<String> wordDict) {
        // sanity check
        if (s == null || s.isEmpty())
            return false;

        TrieNode root = buildTrie(wordDict);
        return bfs(0, s.toCharArray(), root);
    }

    private boolean bfs(int start, final char[] CHS, TrieNode root) {
        final int L = CHS.length;

        Deque<TrieNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean[] visited = new boolean[L];

        while (!queue.isEmpty() && start < L) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TrieNode cur = queue.poll();
                int idx = CHS[start] - 'a';
                if (cur.children[idx] != null) {
                    queue.add(cur.children[idx]);
                    if (cur.children[idx].isWord && !visited[start]) {
                        queue.add(root);
                        visited[start] = true;
                    }
                }
            }
            if (!queue.isEmpty())
                ++start;
        }

        if (start == L && visited[start - 1])
            return true;

        return false;
    }

    private TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();

        for (String word : wordDict) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                int start = ch - 'a';
                if (cur.children[start] == null)
                    cur.children[start] = new TrieNode();

                cur = cur.children[start];
            }

            cur.isWord = true;
        }

        return root;
    }

    private class TrieNode {
        protected boolean isWord;
        protected TrieNode[] children;

        protected TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
}