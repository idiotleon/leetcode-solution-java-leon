/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 * 
 * Time Complexity:     O(N * L)
 *  L, average length of the strings in the folders
 * 
 * Space Complexity:    O(N * L)
 *  L, average length of the strings in the folders
 * 
 * References:
 *  https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/discuss/409028/JavaPython-3-3-methods-from-O(n-*-(logn-%2B-m-2))-to-O(n-*-m)-w-brief-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl3.lc1233;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0Trie {
    public List<String> removeSubfolders(String[] folders) {
        TrieNode root = buildTrie(folders);
        return bfs(root, folders);
    }

    private List<String> bfs(TrieNode root, String[] folders) {
        List<String> res = new ArrayList<String>();
        Deque<TrieNode> queue = new ArrayDeque<TrieNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();
            if (node.index >= 0)
                res.add(folders[node.index]);

            for (int i = 0; i < 27; ++i) {
                if (node.children[i] != null && !(i == 26 && node.index >= 0))
                    queue.offer(node.children[i]);
            }
        }

        return res;
    }

    private TrieNode buildTrie(String[] folders) {
        final int N = folders.length;
        TrieNode root = new TrieNode();
        for (int i = 0; i < N; ++i) {
            TrieNode cur = root;
            for (char ch : folders[i].toCharArray()) {
                int idx = ch == '/' ? 26 : ch - 'a';
                if (cur.children[idx] == null)
                    cur.children[idx] = new TrieNode();
                cur = cur.children[idx];
            }

            cur.index = i;
        }

        return root;
    }

    private class TrieNode {
        protected int index;
        protected TrieNode[] children;

        protected TrieNode() {
            this.index = -1;
            this.children = new TrieNode[27];
        }
    }
}