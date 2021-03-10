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

public class SolutionApproach0DFSRecursive {
    private static enum State {
        SAFE, UNSAFE
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (graph == null || graph.length == 0)
            return ans;

        final int N = graph.length;
        State[] states = new State[N];
        for (int i = 0; i < N; i++)
            if (isSafe(i, states, graph))
                ans.add(i);

        return ans;
    }

    private boolean isSafe(int cur, State[] states, int[][] graph) {
        if (states[cur] != null)
            return states[cur] == State.SAFE;

        states[cur] = State.UNSAFE;
        for (int next : graph[cur])
            if (!isSafe(next, states, graph))
                return false;

        states[cur] = State.SAFE;

        return true;
    }
}