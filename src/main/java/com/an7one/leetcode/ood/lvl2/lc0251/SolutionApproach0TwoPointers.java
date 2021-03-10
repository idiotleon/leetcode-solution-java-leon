package com.an7one.leetcode.ood.lvl2.lc0251;

public class SolutionApproach0TwoPointers {
    private int[][] matrix;
    private int row;
    private int col;

    public SolutionApproach0TwoPointers(int[][] v) {
        this.matrix = v;
        this.row = this.col = 0;
    }

    public int next() {
        if (!hasNext())
            return -1;
        return matrix[row][col++];
    }

    public boolean hasNext() {
        final int NR = matrix.length;
        while (row < NR && col == matrix[row].length) {
            ++row;
            col = 0;
        }

        return row < NR;
    }
}