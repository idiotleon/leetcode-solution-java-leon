package com.an7one.leetcode.lvl5.lc0212;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * https://leetcode.com/problems/word-search-ii/
 *
 * Time Complexity: O(NR * NC * (4 ^ L)) + O(N * L) ~ O(NR * NC * (4 ^ L))
 *  NR, NC, sizes/boundaries of the array
 *  N, number of words in the "words"(input)
 *  L, the average length of each word
 *
 * Space Complexity: O(N * L) + O(max(L)) ~ O(N * L)
 *  N, the number of words in the "words"(input)
 *  L, the average length of each word
 *  O(max(L)), space consumed by call stacks
 *
 * Reference:
 * https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BacktrackWithTrie {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };
    private static final char IMPOSSIBLE = '#';

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        // sanity check
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return ans;

        final int NR = board.length, NC = board[0].length;

        TrieNode root = buildTrie(words);
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                backtrack(row, col, board, root, ans);
            }
        }

        return ans;
    }

    private void backtrack(int row, int col, char[][] board, TrieNode node, List<String> res) {
        final int NR = board.length, NC = board[0].length;
        // termination conditions
        if (row < 0 || row >= NR || col < 0 || col >= NC)
            return;
        char cur = board[row][col];
        int idx = cur - 'a';
        if (cur == IMPOSSIBLE || node.children[idx] == null)
            return;

        node = node.children[idx];
        if (node.word != null) { // found one
            res.add(node.word);
            node.word = null; // de-duplicate
        }

        // to backtrack
        board[row][col] = IMPOSSIBLE;
        for (int d = 0; d < 4; d++) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            backtrack(r, c, board, node, res);
        }
        board[row][col] = cur;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (final char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();

                node = node.children[idx];
            }

            node.word = word;
        }

        return root;
    }

    private static class TrieNode {
        private String word;
        private final TrieNode[] children;

        private TrieNode() {
            this.word = null;
            this.children = new TrieNode[26];
        }
    }
}