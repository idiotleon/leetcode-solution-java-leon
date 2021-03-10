/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * 
 * Time Complexity:     O(V + E) ~ O(N + TOTAL_ELEMENTS)
 * Space Complexity:    O(V + E) ~ O(N + TOTAL_ELEMENTS)
 * 
 * References:
 *  https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand!/190274
 *  https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand! 
 */
package com.an7one.leetcode.lvl3.lc0802;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFSRecursive1 {
    private static final int NOT_VISITED = 0;
    private static final int SAFE = 1;
    private static final int UNSAFE = 2;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (graph == null || graph.length == 0)
            return ans;

        final int N = graph.length;
        int[] states = new int[N];

        for (int i = 0; i < N; i++)
            if (isSafe(i, states, graph))
                ans.add(i);

        return ans;
    }

    private boolean isSafe(int cur, int[] states, int[][] graph) {
        if (states[cur] != NOT_VISITED)
            return states[cur] == SAFE;

        states[cur] = UNSAFE;
        for (int next : graph[cur])
            if (!isSafe(next, states, graph))
                return false;

        states[cur] = SAFE;

        return true;
    }
}