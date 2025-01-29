package com.idiotleon.leetcode.lvl3.lc0261;

import java.util.Arrays;

import static com.idiotleon.util.Constant.WARNING.UNUSED;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/graph-valid-tree/">lc0261</a>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(UNUSED)
public class Solution0UnionFind {
    public boolean validTree(int n, int[][] edges) {
        final int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // to perform union find
        for (int[] edge : edges) {
            int rootX = find(nums, edge[0]);
            int rootY = find(nums, edge[1]);

            // if two vertices happen to be in the same set
            // then there is a cycle
            if (rootX == rootY) {
                return false;
            }

            // to union
            nums[rootX] = rootY;
        }

        return edges.length == n - 1;
    }

    private int find(int[] nums, int i) {
        if (nums[i] == -1) {
            return i;
        }
        return find(nums, nums[i]);
    }
}