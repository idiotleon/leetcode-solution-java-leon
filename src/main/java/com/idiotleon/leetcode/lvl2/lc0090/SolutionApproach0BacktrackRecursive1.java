package com.idiotleon.leetcode.lvl2.lc0090;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Leon
 * https://leetcode.com/problems/subsets-ii/
 * <p>
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 * <p>
 * References:
 * https://leetcode.com/problems/subsets/solution/
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BacktrackRecursive1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        Arrays.sort(nums);
        boolean[] used = new boolean[N];

        for (int size = 0; size <= N; ++size)
            backtrack(0, new ArrayList<>(), used, nums, size, ans);

        return ans;
    }

    private void backtrack(int startIdx, List<Integer> path, boolean[] used, int[] nums, final int SIZE,
                           List<List<Integer>> paths) {
        final int N = nums.length;
        if (path.size() == SIZE) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = startIdx; i < N; ++i) {
            if (used[i] || (i > startIdx && nums[i - 1] == nums[i] && !used[i - 1]))
                continue;

            path.add(nums[i]);
            backtrack(i + 1, path, used, nums, SIZE, paths);
            path.remove(path.size() - 1);
        }
    }
}