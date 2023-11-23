package com.idiotleon.leetcode.lvl3.lc1424;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/diagonal-traverse-ii/">LC1424</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // sanity check
        if (nums == null || nums.isEmpty()) {
            return new int[0];
        }

        // boundaries
        final int NR = nums.size();
        int longest = 0, count = 0;
        for (final List<Integer> num : nums) {
            count += num.size();
            longest = Math.max(longest, num.size());
        }
        // for MOD/key-hashing purpose
        final int NC = longest;

        final int[] ans = new int[count];
        int idx = 0;

        final Set<Integer> visited = new HashSet<>();
        visited.add(hash(0, 0, NC));

        final Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(hash(0, 0, NC));

        while (!queue.isEmpty()) {
            final int sizeQ = queue.size();

            for (int i = 0; i < sizeQ; ++i) {
                final int cur = queue.removeFirst();
                final int row = cur / NC, col = cur % NC;
                ans[idx++] = nums.get(row).get(col);

                if (isValid(row + 1, col, nums) && !visited.contains(hash(row + 1, col, NC))) {
                    final int hash = hash(row + 1, col, NC);
                    queue.add(hash);
                    visited.add(hash);
                }

                if (isValid(row, col + 1, nums) && !visited.contains(hash(row, col + 1, NC))) {
                    final int hash = hash(row, col + 1, NC);
                    queue.add(hash);
                    visited.add(hash);
                }
            }
        }

        return ans;
    }

    private int hash(final int row, final int col, final int NC) {
        return row * NC + col;
    }

    private boolean isValid(final int row, final int col, final List<List<Integer>> nums) {
        return row >= 0 && row < nums.size() && col >= 0 && col < nums.get(row).size();
    }
}