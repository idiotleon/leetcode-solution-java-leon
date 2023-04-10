/**
 * @author: Leon
 * https://leetcode.com/problems/subsets/
 * 
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 */
package com.idiotleon.leetcode.lvl2.lc0078;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        for (int size = 0; size <= N; ++size) {
            backtrack(0, new ArrayList<>(), nums, size, ans);
        }

        return ans;
    }

    private void backtrack(int startIdx, final List<Integer> PATH, int[] nums, final int SIZE,
            final List<List<Integer>> PATHS) {
        final int N = nums.length;
        if (PATH.size() == SIZE) {
            PATHS.add(new ArrayList<>(PATH));
            return;
        }

        for (int i = startIdx; i < N; ++i) {
            PATH.add(nums[i]);
            backtrack(i + 1, PATH, nums, SIZE, PATHS);
            PATH.remove(PATH.size() - 1);
        }
    }
}