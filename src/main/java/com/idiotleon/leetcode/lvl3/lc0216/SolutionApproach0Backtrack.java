/**
 * @author: Leon
 * https://leetcode.com/problems/combination-sum-iii/
 * 
 * Time Complexity:     O(9 ^ k)
 * Space Complexity:    O(k)
 */
package com.idiotleon.leetcode.lvl3.lc0216;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        final int FACTORIAL_NINE = 362880;
        if (k <= 0 || k > 9 || n <= 0 || n > FACTORIAL_NINE)
            return ans;

        backtrack(k, n, 1, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(final int K, final int N, int start, final List<Integer> PATH,
            final List<List<Integer>> PATHS) {
        if (N < 0 || K < 0)
            return;

        if (K == 0) {
            if (N == 0) {
                PATHS.add(new ArrayList<>(PATH));
                return;
            }
        }

        for (int i = start; i < 10; i++) {
            PATH.add(i);
            backtrack(K - 1, N - i, i + 1, PATH, PATHS);
            PATH.remove(PATH.size() - 1);
        }
    }
}