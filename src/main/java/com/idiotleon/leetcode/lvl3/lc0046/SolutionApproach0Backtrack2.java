/**
 * https://leetcode.com/problems/permutations/
 * 
 * Time Complexity:     O((1 ~ N) * N!)
 * Space Complexity:    O(N!)
 * 
 * References:
 *  https://leetcode.com/problems/permutations/solution/
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
package com.idiotleon.leetcode.lvl3.lc0046;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        backtrack(new ArrayList<Integer>(), nums, ans);

        return ans;
    }

    private void backtrack(List<Integer> path, int[] nums, List<List<Integer>> paths) {
        final int N = nums.length;
        if (path.size() == N) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < N; i++) {
            // time complexity: O(N)
            if (path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            backtrack(path, nums, paths);
            path.remove(path.size() - 1);
        }
    }
}