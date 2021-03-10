/**
 * https://leetcode.com/problems/subsets/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N * 2 ^ N) ~ O(N * (2 ^ N))
 *  `ans.add(new ArrayList<Integer>(intermediate));` is of O(N)
 * 
 * Space Complexity:    O(N * (2 ^ N))
 * 
 * References:
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
package com.an7one.leetcode.lvl2.lc0078;

// import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> PATHS = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return PATHS;

        // not necessary
        // Arrays.sort(nums);

        final List<Integer> PATH = new ArrayList<>();
        backtrack(0, PATH, nums, PATHS);
        return PATHS;
    }

    private void backtrack(int startIdx, final List<Integer> PATH, int[] nums, final List<List<Integer>> PATHS) {
        final int N = nums.length;
        PATHS.add(new ArrayList<>(PATH));

        for (int i = startIdx; i < N; ++i) {
            PATH.add(nums[i]);
            backtrack(i + 1, PATH, nums, PATHS);
            PATH.remove(PATH.size() - 1);
        }
    }
}