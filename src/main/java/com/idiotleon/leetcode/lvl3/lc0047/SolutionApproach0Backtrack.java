package com.idiotleon.leetcode.lvl3.lc0047;

import com.idiotleon.util.Constant;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations-ii/">LC0047</a>
 * <p>
 * Time Complexity:     O(N * N!)
 * Space Complexity:    O(N * N!) / O(1) + O(N * lg(N)) + O(N)
 * <p>
 * Reference:
 * <a href="https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Backtrack {
    public List<List<Integer>> permuteUnique(int[] nums) {
        final List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0) {
            return ans;
        }

        final int N = nums.length;
        // for duplicates
        final boolean[] used = new boolean[N];
        Arrays.sort(nums);

        backtrack(new ArrayList<Integer>(), used, nums, ans);

        return ans;
    }

    private void backtrack(final List<Integer> path, final boolean[] used, final int[] nums, final List<List<Integer>> paths) {
        final int N = nums.length;
        if (path.size() == N) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backtrack(path, used, nums, paths);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}