/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * 
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 * 
 * References:
 *  https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/533109/Java-BFSDFS-Solutions-Clean-code
 */
package com.an7one.leetcode.lvl2.lc1376;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0BFS {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTimes) {
        List<List<Integer>> graph = buildGraph(manager, n);

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(headID, 0));

        int timeNeeded = 0;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                Node cur = queue.poll();
                int mgr = cur.manager;
                int informTime = cur.informTime;

                timeNeeded = Math.max(timeNeeded, informTime);

                for (int employee : graph.get(mgr)) {
                    queue.offer(new Node(employee, informTime + informTimes[mgr]));
                }
            }
        }

        return timeNeeded;
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

    private class Node {
        private int manager;
        private int informTime;

        private Node(int manager, int informTime) {
            this.manager = manager;
            this.informTime = informTime;
        }
    }
}
