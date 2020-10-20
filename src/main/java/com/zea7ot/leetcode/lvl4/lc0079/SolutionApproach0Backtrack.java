/**
 * https://leetcode.com/problems/word-search/
 * 
 * Time Complexity:     O(NR * NC * (4 ^ L))
 *  NR, NC: sizes of the char[][] board
 *  L: length of the word
 *  
 * Space Complexity:    O(L)
 *  L: length of the word
 */
package com.zea7ot.leetcode.lvl4.lc0079;

public class SolutionApproach0Backtrack {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };
    private static final int MOD = 256;

    public boolean exist(char[][] board, String word) {
        // sanity check
        if (board == null || board.length == 0 || word == null || word.isEmpty())
            return false;

        // boundaries of char[][] board
        final int NR = board.length, NC = board[0].length;

        // backtrack/dfs
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (backtrack(row, col, 0, word, board))
                    return true;
            }
        }

        return false;
    }

    private boolean backtrack(int row, int col, int idx, String word, char[][] board) {
        final int L = word.length();
        if (idx == L)
            return true;

        final int NR = board.length, NC = board[0].length;
        if (row < 0 || col < 0 || row >= NR || col >= NC || board[row][col] != word.charAt(idx))
            return false;

        board[row][col] ^= MOD;

        boolean exists = false;

        for (int d = 0; d < 4; ++d) {
            int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];
            exists = exists || backtrack(nextRow, nextCol, idx + 1, word, board);
        }

        board[row][col] ^= MOD;

        return exists;
    }
}