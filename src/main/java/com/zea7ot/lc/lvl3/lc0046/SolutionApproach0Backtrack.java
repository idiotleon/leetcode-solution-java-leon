/**
 * https://leetcode.com/problems/permutations/
 * 
 * Time Complexity:     O(N!)
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl3.lc0046;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        boolean[] used = new boolean[N];

        backtrack(new ArrayList<>(), nums, used, ans);

        return ans;
    }

    private void backtrack(List<Integer> path, int[] nums, boolean[] used, List<List<Integer>> paths) {
        final int N = nums.length;
        if (path.size() == N) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (used[i])
                continue;

            used[i] = true;
            path.add(nums[i]);
            backtrack(path, nums, used, paths);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}