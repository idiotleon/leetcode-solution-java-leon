package com.an7one.leetcode.lvl3.lc0498;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SolutionApproach0BFS1 {
    public int[] findDiagonalOrder(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0)
            return new int[0];

        // boundaries
        final int NR = matrix.length, NC = matrix[0].length;

        int[] ans = new int[NR * NC];
        int idx = 0;

        // BFS
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(hash(0, 0, NC));

        Set<Integer> visited = new HashSet<Integer>();
        visited.add(hash(0, 0, NC));

        // Zig-Zag level order traversal
        LinkedList<Integer> intermediate = new LinkedList<Integer>();
        int level = 0;

        while (!queue.isEmpty()) {
            intermediate.clear();
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; i++) {
                int pos = queue.poll();
                int row = pos / NC, col = pos % NC;

                if (level % 2 == 0)
                    intermediate.addLast(pos);
                else
                    intermediate.addFirst(pos);

                if (isValid(row + 1, col, matrix) && !visited.contains(hash(row + 1, col, NC))) {
                    queue.add(hash(row + 1, col, NC));
                    visited.add(hash(row + 1, col, NC));
                }

                if (isValid(row, col + 1, matrix) && !visited.contains(hash(row, col + 1, NC))) {
                    queue.add(hash(row, col + 1, NC));
                    visited.add(hash(row, col + 1, NC));
                }
            }

            for (int pos : intermediate) {
                ans[idx++] = matrix[pos / NC][pos % NC];
            }

            ++level;
        }

        return ans;
    }

    private int hash(int row, int col, final int NC) {
        return row * NC + col;
    }

    private boolean isValid(int row, int col, int[][] matrix) {
        final int NR = matrix.length, NC = matrix[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC)
            return false;

        return true;
    }
}