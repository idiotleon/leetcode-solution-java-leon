package com.idiotleon.leetcode.lvl3.lc1424;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/diagonal-traverse-ii/">LC1424</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity;    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TreeMap {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        final TreeMap<Integer, Integer> idxMap = new TreeMap<>();
        for (int i = 0; i < nums.size(); i++) {
            idxMap.put(0 - i, 0);
        }

        int index = 0;
        final List<Integer> ans = new ArrayList<>();

        while (!idxMap.isEmpty()) {
            final int key = idxMap.ceilingKey(index);

            while (key != idxMap.size()) {
                int row = 0 - key;
                int col = idxMap.get(key);
                ans.add(nums.get(row).get(col));

                idxMap.put(key, col + 1);

                if (col == nums.get(row).size()) idxMap.remove(key);
            }

            --index;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}