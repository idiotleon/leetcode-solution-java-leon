package com.idiotleon.leetcode.lvl3.lc0046;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/permutations/">LC0046</a>
 * <p>
 * Time Complexity:     O((1 ~ N) * N!)
 * Space Complexity:    O(N!)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/permutations/solution/">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Backtrack {
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0) {
            return ans;
        }

        final int N = nums.length;
        final boolean[] used = new boolean[N];
        backtrack(new ArrayList<>(), nums, used, ans);

        return ans;
    }

    private void backtrack(final List<Integer> path, final int[] nums, final boolean[] used, final List<List<Integer>> paths) {
        final int N = nums.length;
        if (path.size() == N) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (used[i]) continue;

            used[i] = true;
            path.add(nums[i]);
            backtrack(path, nums, used, paths);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}