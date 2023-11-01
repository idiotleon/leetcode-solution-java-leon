package com.idiotleon.leetcode.lvl3.lc0040;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Leon
 * https://leetcode.com/problems/combination-sum-ii/
 * <p>
 * Time Complexity:     O(N ^ target) in the worst case
 * Space Complexity:    O(target) in the worst case
 * <p>
 * References:
 * https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/435867
 * https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Backtrack {
    public List<List<Integer>> combinationSum2(final int[] candidates, int target) {
        final List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (candidates == null || candidates.length == 0 || target < 1) {
            return ans;
        }

        Arrays.sort(candidates);
        final int N = candidates.length;
        final boolean[] used = new boolean[N];

        backtrack(0, target, new ArrayList<>(), used, candidates, ans);
        return ans;
    }

    private void backtrack(final int startIdx, final int target, final List<Integer> path, final boolean[] used, final int[] candidates, final List<List<Integer>> paths) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            paths.add(new ArrayList<>(path));
            return;
        }

        // if the candidates array is sorted, "target >= candidates[i]" is used to prune
        // further DFS
        for (int i = startIdx; i < candidates.length && target >= candidates[i]; ++i) {
            if (used[i] || (i > startIdx && !used[i - 1] && candidates[i - 1] == candidates[i])) {
                continue;
            }
            used[i] = true;
            path.add(candidates[i]);
            backtrack(i, target - candidates[i], path, used, candidates, paths);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}