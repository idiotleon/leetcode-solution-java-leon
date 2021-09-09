package com.an7one.leetcode.lvl3.lc0039;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * Time Complexity:     O(2 ^ target)
 *  O(2 ^ N), in the worst case
 *
 * Space Complexity:    O(target)
 *
 *
 * References:
 *  https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/323613
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Backtrack {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (candidates == null || candidates.length == 0)
            return ans;

        // to help prune a little bit
        Arrays.sort(candidates);

        backtrack(0, target, new ArrayList<>(), candidates, ans);

        return ans;
    }

    private void backtrack(int startIdx, int target, List<Integer> path, int[] candidates, List<List<Integer>> paths) {

        final int N = candidates.length;
        if (target < 0)
            return;

        if (target == 0) {
            paths.add(new ArrayList<>(path));
            return;
        }

        // please pay attention to these two equivalent backtrack approaches
        for (int i = startIdx; i < N && target >= candidates[i]; ++i) {
            // target -= candidates[i];
            path.add(candidates[i]);
            // backtrack(i, target, path, candidates, paths);
            backtrack(i, target - candidates[i], path, candidates, paths);
            // target += candidates[i];
            path.remove(path.size() - 1);
        }
    }
}