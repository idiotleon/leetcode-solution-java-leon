/**
 * @author: Leon
 * https://leetcode.com/problems/factor-combinations/
 * 
 * Time Complexity:     ?O(n ^ 2)
 * Space Complexity:    O(lg(n))
 */
package com.zea7ot.leetcode.lvl3.lc0254;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (n <= 3)
            return ans;

        backtrack(n, 2, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int target, int start, List<Integer> path, List<List<Integer>> paths) {
        if (target == 1 && path.size() > 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= target; ++i) {
            if (target % i != 0)
                continue;
            path.add(i);
            backtrack(target / i, i, path, paths);
            path.remove(path.size() - 1);
        }
    }
}