/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl3.lc1424;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0BFS {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // sanity check
        if (nums == null || nums.isEmpty())
            return new int[0];

        // bondaries
        final int NR = nums.size();
        int max = 0, count = 0;
        for (int i = 0; i < NR; i++) {
            count += nums.get(i).size();
            max = Math.max(max, nums.get(i).size());
        }
        // for MOD/key-hashing purpose
        final int NC = max;

        int[] ans = new int[count];
        int idx = 0;

        Set<Integer> visited = new HashSet<Integer>();
        visited.add(hash(0, 0, NC));

        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(hash(0, 0, NC));

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; i++) {
                int cur = queue.poll();
                int row = cur / NC, col = cur % NC;
                ans[idx++] = nums.get(row).get(col);

                if (isValid(row + 1, col, nums) && !visited.contains(hash(row + 1, col, NC))) {
                    int hash = hash(row + 1, col, NC);
                    queue.add(hash);
                    visited.add(hash);
                }

                if (isValid(row, col + 1, nums) && !visited.contains(hash(row, col + 1, NC))) {
                    int hash = hash(row, col + 1, NC);
                    queue.add(hash);
                    visited.add(hash);
                }
            }
        }

        return ans;
    }

    private int hash(int row, int col, final int NC) {
        return row * NC + col;
    }

    private boolean isValid(int row, int col, List<List<Integer>> nums) {
        if (row < 0 || row >= nums.size() || col < 0 || col >= nums.get(row).size())
            return false;

        return true;
    }
}