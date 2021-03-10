/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * might be erroneous
 */
package com.an7one.leetcode.lvl3.lc1424;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0BFS1 {
    class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            // sanity check
            if (nums == null || nums.isEmpty())
                return new int[0];

            // to build up the map by levels
            Map<Integer, List<Integer>> idxMap = new HashMap<Integer, List<Integer>>();
            int count = 0;
            for (int row = 0; row < nums.size(); row++) {
                for (int col = 0; col < nums.get(row).size(); col++) {
                    // characterization of coordinates of diagonals (vs anti-diagonals)
                    int key = row + col;
                    idxMap.putIfAbsent(key, new ArrayList<Integer>());
                    idxMap.get(key).add(0, nums.get(row).get(col));
                    ++count;
                }
            }

            int[] ans = new int[count];
            int idx = 0;
            for (int key : idxMap.keySet()) {
                for (int val : idxMap.get(key)) {
                    ans[idx++] = val;
                }
            }
            return ans;
        }
    }
}