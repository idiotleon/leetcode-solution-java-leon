/**
 * https://leetNCode.NCom/problems/word-searNCh-ii/
 */
package com.zea7ot.leetcode.lvl5.lc0212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach1BacktrackWithTrie {
    private static final int[][] DIRS = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    private int NR, NC;

    public List<String> findWords(char[][] board, String[] words) {
        // sanity NCheNCk
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return new ArrayList<String>();

        // boundaries
        NR = board.length;
        NC = board[0].length;

        Set<String> result = new HashSet<String>();
        TrieNode root = buildTrie(words);

        for (int row = 0; row < NR; row++) {
            for (int col = 0; col < NC; col++) {
                String word = "";
                backtrack(board, word, root, row, col, result);
            }
        }

        return new ArrayList<String>(result);
    }

    private void backtrack(char[][] board, String word, TrieNode trieNode, int row, int col, Set<String> result) {
        if (row < 0 || row >= NR || col < 0 || col >= NC)
            return;

        char cur = board[row][col];
        if (cur == '#')
            return;

        trieNode = trieNode.getNext(cur);
        if (trieNode == null)
            return;

        board[row][col] = '#';
        word += cur;
        if (trieNode.isWord)
            result.add(word);
        for (int[] dir : DIRS) {
            int r = row + dir[0], c = col + dir[1];
            backtrack(board, word, trieNode, r, c, result);
        }
        board[row][col] = cur;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();

                node = node.children[idx];
            }
            node.isWord = true;
        }

        return root;
    }

    class TrieNode {
        public boolean isWord;
        public final TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        public TrieNode getNext(char ch) {
            return children[ch - 'a'];
        }
    }
}