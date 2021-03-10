/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * 
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 * 
 * References:
 *  https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/533109/Java-BFSDFS-Solutions-Clean-code
 *  https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/532560/JavaC%2B%2BPython-DFS
 */
package com.an7one.leetcode.lvl2.lc1376;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
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
