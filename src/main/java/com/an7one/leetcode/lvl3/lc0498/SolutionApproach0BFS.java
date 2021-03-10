/**
 * https://leetcode.com/problems/diagonal-traverse/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.an7one.leetcode.lvl3.lc0498;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SolutionApproach0BFS {
    public int[] findDiagonalOrder(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        final int NR = matrix.length, NC = matrix[0].length;

        Map<Integer, LinkedList<Integer>> idxMap = new HashMap<>();
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                // characterization of coordinates of diagonals (vs anti-diagonals)
                int level = row + col;
                idxMap.putIfAbsent(level, new LinkedList<Integer>());
                if (level % 2 == 0)
                    idxMap.get(level).addFirst(matrix[row][col]);
                else
                    idxMap.get(level).addLast(matrix[row][col]);
            }
        }

        int[] ans = new int[NR * NC];
        int idx = 0;
        for (Map.Entry<Integer, LinkedList<Integer>> entry : idxMap.entrySet()) {
            for (int val : entry.getValue())
                ans[idx++] = val;

        }

        return ans;
    }
}