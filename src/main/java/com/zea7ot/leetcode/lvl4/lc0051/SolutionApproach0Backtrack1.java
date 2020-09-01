/**
 * https://leetcode.com/problems/n-queens/
 * 
 * Time Complexity:     O((N ^ 3) * N!)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/n-queens/discuss/19808/Accepted-4ms-c%2B%2B-solution-use-backtracking-and-bitmask-easy-understand.
 */
package com.zea7ot.leetcode.lvl4.lc0051;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        // sanity check
        if (n < 1)
            return ans;

        char[][] board = new char[n][n];
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                board[row][col] = '.';
            }
        }

        backtrack(board, 0, n, ans);
        return ans;
    }

    private void backtrack(char[][] board, int col, final int N, List<List<String>> res) {
        if (col == N) {
            res.add(construct(board, N));
            return;
        }

        for (int row = 0; row < N; ++row) {
            if (validate(row, col, board, N)) {
                board[row][col] = 'Q';
                backtrack(board, col + 1, N, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean validate(final int ROW, final int COL, char[][] board, final int N) {
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < COL; ++col) {
                if (board[row][col] == 'Q' && (ROW + col == COL + row || ROW + COL == row + col || ROW == row)) {
                    return false;
                }
            }
        }

        return true;
    }

    private List<String> construct(char[][] board, final int N) {
        List<String> res = new ArrayList<>();
        for (int row = 0; row < N; ++row) {
            String str = new String(board[row]);
            res.add(str);
        }

        return res;
    }
}