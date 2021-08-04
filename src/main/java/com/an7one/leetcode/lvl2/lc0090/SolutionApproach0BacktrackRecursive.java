package com.an7one.leetcode.lvl2.lc0090;

import com.an7one.util.Constant;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * <p>
 * Time Complexity:     O(N * 2 ^ N) + O(N * lg(N)) ~ O(N * 2 ^ 2)
 * `ans.add(new ArrayList<Integer>(intermediate));` is of O(N)
 * <p>
 * Space Complexity:    O(N *  (2 ^ N))
 * <p>
 * References:
 * https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BacktrackRecursive {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        final List<List<Integer>> paths = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return paths;

        Arrays.sort(nums);
        final List<Integer> path = new ArrayList<>();
        backtrack(0, path, nums, paths);
        return paths;
    }

    private void backtrack(int startIdx, final List<Integer> path, final int[] nums, final List<List<Integer>> paths) {
        final int N = nums.length;
        paths.add(new ArrayList<>(path));

        for (int i = startIdx; i < N; ++i) {
            if (i != startIdx && nums[i - 1] == nums[i])
                continue;

            path.add(nums[i]);
            backtrack(i + 1, path, nums, paths);
            path.remove(path.size() - 1);
        }
    }
}