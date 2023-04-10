/**
 * https://leetcode.com/problems/n-queens/
 * 
 * Time Complexity: O(`n` * `n`!)
 * 
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=178&cur_album_id=1318883740306948097#rd
 */
package com.idiotleon.leetcode.lvl4.lc0051;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    private static final char EMPTY = '.';
    private static final char QUEEN = 'Q';

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        // sanity check
        if (n < 1)
            return ans;

        char[][] board = new char[n][n];
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                board[row][col] = EMPTY;
            }
        }

        boolean[] isSameColumn = new boolean[n];
        boolean[] isSameMainDiagonal = new boolean[2 * n - 1];
        boolean[] isSameAntidiagonal = new boolean[2 * n - 1];

        backtrack(0, isSameMainDiagonal, isSameAntidiagonal, isSameColumn, n, board, ans);

        return ans;
    }

    private void backtrack(int row, boolean[] isSameMainDiagonal, boolean[] isSameAntidiagonal, boolean[] isSameColumn,
            final int N, char[][] board, List<List<String>> res) {
        if (row == N) {
            res.add(construct(board, N));
            return;
        }

        for (int col = 0; col < N; ++col) {
            if (isSameColumn[col] || isSameMainDiagonal[row + N - col - 1] || isSameAntidiagonal[row + col])
                continue;

            // to prepare for backtrack
            isSameColumn[col] = true;
            isSameMainDiagonal[row + N - col - 1] = true;
            isSameAntidiagonal[row + col] = true;
            board[row][col] = QUEEN;

            // to backtrack to the next state
            backtrack(row + 1, isSameMainDiagonal, isSameAntidiagonal, isSameColumn, N, board, res);

            // to backtrack to the previous state
            board[row][col] = EMPTY;
            isSameColumn[col] = false;
            isSameMainDiagonal[row + N - col - 1] = false;
            isSameAntidiagonal[row + col] = false;
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