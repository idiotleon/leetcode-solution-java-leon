package com.idiotleon.leetcode.lvl3.lc0130;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/surrounded-regions/">LC0130</a>
 * <p>
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0UnionFind {
    private static final int[] DIRS = {0, -1, 0, 1, 0};

    private static final char LETTER_O = 'O';
    private static final char LETTER_X = 'X';
    // not used
    // private static final char PLACE_HOLDER = '.';

    public void solve(char[][] board) {
        // sanity check
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        final int NR = board.length, NC = board[0].length;

        final UnionFind uf = new UnionFind(NR * NC + 1);
        final int dummyNode = NR * NC;

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (board[row][col] != LETTER_O)
                    continue;
                if (row == 0 || row == NR - 1 || col == 0 || col == NC - 1)
                    uf.union(hash(row, col, NC), dummyNode);
                else
                    for (int d = 0; d < 4; ++d) {
                        int r = row + DIRS[d], c = col + DIRS[d + 1];
                        if (r < 0 || r >= NR || c < 0 || c >= NC || board[r][c] != LETTER_O)
                            continue;
                        uf.union(hash(row, col, NC), hash(r, c, NC));
                    }
            }
        }

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (uf.isConnected(hash(row, col, NC), dummyNode))
                    board[row][col] = LETTER_O;
                else
                    board[row][col] = LETTER_X;
            }
        }
    }

    private int hash(final int row, final int col, final int NC) {
        return row * NC + col;
    }

    private static class UnionFind {
        private final int[] roots;

        private UnionFind(int totalNumber) {
            roots = new int[totalNumber];
            // such an initialization is important,
            // without which,
            // roots of 'X's might be collided with ones of 'O's on the border
            for (int i = 0; i < totalNumber; i++) {
                roots[i] = i;
            }
        }

        private void union(int x, int y) {
            int rootx = find(x), rooty = find(y);

            if (rootx != rooty) {
                roots[rooty] = rootx;
            }
        }

        private int find(int i) {
            if (roots[i] != i) {
                roots[i] = find(roots[i]);
            }
            return roots[i];
        }

        private boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}