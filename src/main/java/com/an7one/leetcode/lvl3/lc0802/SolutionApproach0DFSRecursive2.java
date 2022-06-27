package com.an7one.leetcode.lvl3.lc0802;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/">description</a>
 * <p>
 * Time Complexity:     O(V + E) ~ O(`N` + numEdges)
 * Space Complexity:    O(V + E) ~ O(`N` + numEdges)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand!/218665">reference</a>
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand!/190274">reference</a>
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand">reference</a>!
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive2 {
    private static final int NOT_YET_COLORED = 0;
    private static final int BEING_COLORED = 1;
    private static final int COLORED = 2;

    public List<Integer> eventualSafeNodes(final int[][] graph) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (graph == null || graph.length == 0)
            return ans;

        final int N = graph.length;
        final int[] colors = new int[N];

        for (int i = 0; i < N; ++i)
            if (isSafe(i, colors, graph))
                ans.add(i);

        return ans;
    }

    private boolean isSafe(final int cur, final int[] colors, final int[][] graph) {
        if (colors[cur] != NOT_YET_COLORED)
            return colors[cur] == COLORED;

        colors[cur] = BEING_COLORED;
        for (int next : graph[cur]) {
            if (!isSafe(next, colors, graph))
                return false;
        }

        colors[cur] = COLORED;

        return true;
    }
}