package com.idiotleon.leetcode.ood.lvl3.lc0348;

/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 * <p>
 * Time Complexity:     O(1)
 * Space Complexity:    O(`n`)
 * <p>
 * Reference:
 * https://leetcode.com/problems/design-tic-tac-toe/discuss/81898/Java-O(1)-solution-easy-to-understand
 */
public class SolutionApproach0LinearScan {
    private final int[] rows, cols;
    private int diagonal, antiDiagonal;
    private final int N;

    /**
     * Initialize your data structure here.
     */
    public SolutionApproach0LinearScan(int n) {
        this.N = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal = 0;
        this.antiDiagonal = 0;
    }

    public int move(int row, int col, int player) {
        final int toAdd = player == 1 ? 1 : -1;
        final int TARGET = player == 1 ? N : -N;

        rows[row] += toAdd;
        if (TARGET == rows[row])
            return player;

        cols[col] += toAdd;
        if (TARGET == cols[col])
            return player;

        if (row - col == 0) {
            diagonal += toAdd;
            if (TARGET == diagonal)
                return player;
        }

        if (row + col == N - 1) {
            antiDiagonal += toAdd;
            if (TARGET == antiDiagonal)
                return player;
        }

        return 0;
    }
}