/**
 * https://leetcode.com/problems/n-queens/
 * 
 * Time Complexity: O(N * N!)
 * 
 * References:
 *  
 */
package com.zea7ot.leetcode.lvl4.lc0051;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
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

        boolean[] column = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        backtrack(board, 0, diag1, diag2, column, n, ans);

        return ans;
    }

    private void backtrack(char[][] board, int idx, boolean[] diag1, boolean[] diag2, boolean[] column, final int N,
            List<List<String>> res) {
        if (idx == N) {
            res.add(construct(board, N));
            return;
        }

        for (int col = 0; col < N; ++col) {
            if (column[col] || diag1[idx + N - col - 1] || diag2[idx + col])
                continue;

            // to prepare for backtrack
            column[col] = true;
            diag1[idx + N - col - 1] = true;
            diag2[idx + col] = true;
            board[idx][col] = 'Q';

            // to start backtrack
            backtrack(board, idx + 1, diag1, diag2, column, N, res);

            // to put the previous state back
            board[idx][col] = '.';
            column[col] = false;
            diag1[idx + N - col - 1] = false;
            diag2[idx + col] = false;
        }
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