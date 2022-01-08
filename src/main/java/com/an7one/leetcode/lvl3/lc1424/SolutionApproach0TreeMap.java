/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 * <p>
 * Time Complexity:     O()
 * Space Complexity;    O()
 */
package com.an7one.leetcode.lvl3.lc1424;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TreeMap {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer, Integer> idxMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.size(); i++)
            idxMap.put(0 - i, 0);

        int index = 0;
        List<Integer> ans = new ArrayList<Integer>();

        while (!idxMap.isEmpty()) {
            int key = idxMap.ceilingKey(index);

            while (key != idxMap.size()) {
                int row = 0 - key;
                int col = idxMap.get(key);
                ans.add(nums.get(row).get(col));

                idxMap.put(key, col + 1);

                if (col == nums.get(row).size()) idxMap.remove(key);
            }

            index--;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}