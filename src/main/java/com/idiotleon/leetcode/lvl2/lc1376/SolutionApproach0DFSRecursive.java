package com.idiotleon.leetcode.lvl2.lc1376;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/">Description</a>
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/533109/Java-BFSDFS-Solutions-Clean-code">...</a>
 *  <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/532560/JavaC%2B%2BPython-DFS">...</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTimes) {
        List<List<Integer>> graph = buildGraph(manager, n);
        return dfs(headID, informTimes, graph);
    }

    private int dfs(int manager, int[] informTimes, List<List<Integer>> graph) {
        int max = 0;
        for (int employee : graph.get(manager)) {
            max = Math.max(max, dfs(employee, informTimes, graph));
        }
        return max + informTimes[manager];
    }

    private List<List<Integer>> buildGraph(int[] manager, final int N) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; ++i) {
            int mgr = manager[i];
            if (mgr != -1) {
                graph.get(mgr).add(i);
            }
        }

        return graph;
    }
}
