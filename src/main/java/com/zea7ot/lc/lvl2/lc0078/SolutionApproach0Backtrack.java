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
package com.zea7ot.lc.lvl2.lc0078;

// import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        // not necessary
        // Arrays.sort(nums);

        backtrack(0, new ArrayList<Integer>(), nums, ans);
        return ans;
    }

    private void backtrack(int startIdx, List<Integer> path, int[] nums, List<List<Integer>> paths) {
        paths.add(new ArrayList<Integer>(path));

        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i + 1, path, nums, paths);
            path.remove(path.size() - 1);
        }
    }
}