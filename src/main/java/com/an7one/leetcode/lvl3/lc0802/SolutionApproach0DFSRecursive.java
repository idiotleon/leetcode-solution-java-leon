package com.an7one.leetcode.lvl3.lc0802;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/">Description</a>
 * <p>
 * Time Complexity:     O(V + E) ~ O(`N` + numEdges)
 * Space Complexity:    O(V + E) ~ O(`N` + numEdges)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand!/190274">reference</a>
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand!">reference<a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    private enum State {
        SAFE, UNSAFE
    }

    public List<Integer> eventualSafeNodes(final int[][] graph) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (graph == null || graph.length == 0)
            return ans;

        final int N = graph.length;
        final State[] states = new State[N];
        for (int i = 0; i < N; ++i) {
            if (isSafe(i, states, graph))
                ans.add(i);
        }

        return ans;
    }

    private boolean isSafe(final int cur, final State[] states, final int[][] graph) {
        if (states[cur] != null)
            return states[cur] == State.SAFE;

        states[cur] = State.UNSAFE;
        for (int next : graph[cur]) {
            if (!isSafe(next, states, graph))
                return false;
        }

        states[cur] = State.SAFE;

        return true;
    }
}