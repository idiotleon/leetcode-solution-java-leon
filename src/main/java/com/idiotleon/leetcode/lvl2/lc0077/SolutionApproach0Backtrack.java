/**
 * https://leetcode.com/problems/combinations/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.idiotleon.leetcode.lvl2.lc0077;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> PATHS = new ArrayList<>();

        final List<Integer> PATH = new ArrayList<>();
        bactrack(1, PATH, n, k, PATHS);
        return PATHS;
    }

    private void bactrack(int startIdx, final List<Integer> PATH, final int N, final int K,
            final List<List<Integer>> PATHS) {
        if (K == 0) {
            PATHS.add(new ArrayList<>(PATH));
            return;
        }

        for (int i = startIdx; i <= N; ++i) {
            PATH.add(i);
            bactrack(i + 1, PATH, N, K - 1, PATHS);
            PATH.remove(PATH.size() - 1);
        }
    }
}