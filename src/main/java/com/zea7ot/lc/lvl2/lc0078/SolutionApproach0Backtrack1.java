/**
 * @author: Leon
 * https://leetcode.com/problems/subsets/
 * 
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 */
package com.zea7ot.lc.lvl2.lc0078;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        for (int size = 0; size <= N; ++size)
            backtrack(0, new ArrayList<>(), nums, size, ans);

        return ans;
    }

    private void backtrack(int startIdx, List<Integer> path, int[] nums, final int SIZE, List<List<Integer>> paths) {
        final int N = nums.length;
        if (path.size() == SIZE) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = startIdx; i < N; ++i) {
            path.add(nums[i]);
            backtrack(i + 1, path, nums, SIZE, paths);
            path.remove(path.size() - 1);
        }
    }
}