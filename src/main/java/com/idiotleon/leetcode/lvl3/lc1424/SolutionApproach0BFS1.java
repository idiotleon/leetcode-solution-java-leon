package com.idiotleon.leetcode.lvl3.lc1424;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/diagonal-traverse-ii/">LC1424</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * might be erroneous
 */
@SuppressWarnings({Constant.WARNING.UNUSED})
public class SolutionApproach0BFS1 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // sanity check
        if (nums == null || nums.isEmpty()) {
            return new int[0];
        }

        // to build up the map by levels
        final Map<Integer, List<Integer>> idxToNums = new HashMap<>();
        int count = 0;
        for (int row = 0; row < nums.size(); ++row) {
            for (int col = 0; col < nums.get(row).size(); ++col) {
                // characterization of coordinates of diagonals (vs anti-diagonals)
                final int key = row + col;
                idxToNums.putIfAbsent(key, new ArrayList<>());
                idxToNums.get(key).add(0, nums.get(row).get(col));
                ++count;
            }
        }

        final int[] ans = new int[count];
        int idx = 0;
        for (int key : idxToNums.keySet()) {
            for (int val : idxToNums.get(key)) {
                ans[idx++] = val;
            }
        }
        return ans;
    }
}