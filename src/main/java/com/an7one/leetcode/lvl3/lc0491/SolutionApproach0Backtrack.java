/**
 * https://leetcode.com/problems/increasing-subsequences/
 * 
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/increasing-subsequences/discuss/97147/Java-solution-beats-100
 *  https://leetcode.com/problems/increasing-subsequences/discuss/97147/Java-solution-beats-100/498426
 */
package com.an7one.leetcode.lvl3.lc0491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        backtrack(0, nums, new LinkedList<Integer>(), ans);
        return ans;
    }

    private void backtrack(int idx, int[] nums, LinkedList<Integer> path, List<List<Integer>> paths) {
        final int N = nums.length;

        if (path.size() > 1)
            paths.add(new ArrayList<Integer>(path));

        Set<Integer> used = new HashSet<Integer>();
        for (int i = idx; i < N; ++i) {
            if (used.contains(nums[i]))
                continue;

            if (path.isEmpty() || nums[i] >= path.peekLast()) {
                used.add(nums[i]);
                path.add(nums[i]);
                backtrack(i + 1, nums, path, paths);
                path.removeLast();
            }
        }
    }
}