/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * 
 * Time Complexity:     O(V + E) ~ O(N + TOTAL_ELEMENTS)
 * Space Complexity:    O(V + E) ~ O(N + TOTAL_ELEMENTS)
 * 
 * References:
 *  https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand!/218665
 *  https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand!/190274
 *  https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand! 
 */
package com.zea7ot.leetcode.lvl3.lc0802;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFSRecursive2 {
    private static final int NOT_YET_COLORED = 0;
    private static final int BEING_COLORED = 1;
    private static final int COLORED = 2;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (graph == null || graph.length == 0)
            return ans;

        final int N = graph.length;
        int[] colors = new int[N];

        for (int i = 0; i < N; ++i)
            if (isSafe(i, colors, graph))
                ans.add(i);

        return ans;
    }

    private boolean isSafe(int cur, int[] colors, int[][] graph) {
        if (colors[cur] != NOT_YET_COLORED)
            return colors[cur] == COLORED;

        colors[cur] = BEING_COLORED;
        for (int next : graph[cur])
            if (!isSafe(next, colors, graph))
                return false;

        colors[cur] = COLORED;

        return true;
    }
}