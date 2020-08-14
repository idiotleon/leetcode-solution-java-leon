/**
 * https://leetcode.com/problems/permutations/
 * 
 * Time Complexity:     O(N!)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
package com.zea7ot.lc.lvl3.lc0046;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        // a `LinkedHashSet` is required, instead of a `HashSet`,
        // to maintain the insertion order,
        // otherwise all orders of elements in the set are the same.
        backtrack(new LinkedHashSet<Integer>(), nums, ans);
        return ans;
    }

    private void backtrack(LinkedHashSet<Integer> path, int[] nums, List<List<Integer>> paths) {
        final int N = nums.length;
        if (path.size() == N) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            backtrack(path, nums, paths);
            path.remove(nums[i]);
        }
    }
}