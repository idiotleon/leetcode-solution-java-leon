/**
 * https://leetcode.com/problems/factor-combinations/
 * 
 * Time Complexity:     ?O(n * lg(n))
 * Space Complexity:    ?O(n * lg(n))
 * 
 * References:
 *  https://leetcode.com/problems/factor-combinations/discuss/68040/My-Recursive-DFS-Java-Solution/165582
 *  https://leetcode.com/problems/factor-combinations/discuss/68040/My-Recursive-DFS-Java-Solution/159196
 */
package com.idiotleon.leetcode.lvl3.lc0254;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (n <= 3)
            return ans;

        backtrack(n, 2, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int target, int start, final List<Integer> PATH, final List<List<Integer>> PATHS) {
        if (target == 1 && PATH.size() > 1) {
            PATHS.add(new ArrayList<>(PATH));
            return;
        }

        for (int i = start; i * i <= target; i++) {
            if (target % i != 0)
                continue;
            PATH.add(i);
            // to collect results during the recursion
            PATH.add(target / i);
            PATHS.add(new ArrayList<>(PATH));
            PATH.remove(PATH.size() - 1);
            backtrack(target / i, i, PATH, PATHS);
            PATH.remove(PATH.size() - 1);
        }
    }
}