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
package com.idiotleon.leetcode.lvl3.lc0491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SolutionApproach0Backtrack1 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Set<List<Integer>> ans = new HashSet<>();

        backtrack(0, nums, new LinkedList<Integer>(), ans);
        return new ArrayList<>(ans);
    }

    private void backtrack(int idx, int[] nums, LinkedList<Integer> path, Set<List<Integer>> paths) {
        final int N = nums.length;
        if (path.size() > 1)
            paths.add(new ArrayList<Integer>(path));

        for (int i = idx; i < N; ++i) {
            if (!path.isEmpty() && nums[i] < path.peekLast())
                continue;
            path.add(nums[i]);
            backtrack(i + 1, nums, path, paths);
            path.removeLast();
        }
    }
}