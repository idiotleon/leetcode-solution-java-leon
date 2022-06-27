package com.an7one.leetcode.lvl3.lc0797;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">description</a>
 * <p>
 * Time Complexity:     O(V + E) ~ O(N + TOTAL_ELEMENTS)
 * Space Complexity:    O(V + E) ~ O(N + TOTAL_ELEMENTS)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final List<List<Integer>> paths = new ArrayList<>();
        // sanity check
        if (graph == null || graph.length == 0)
            return paths;

        final int N = graph.length;
        final int DESTINATION = N - 1;

        final Deque<LinkedList<Integer>> queue = new ArrayDeque<>();
        queue.offer(new LinkedList<>(Arrays.asList(0)));

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                final LinkedList<Integer> list = queue.poll();
                int cur = list.getLast();
                if (cur == DESTINATION) {
                    paths.add(new ArrayList<>(list));
                    continue;
                }

                for (int next : graph[cur]) {
                    final LinkedList<Integer> nextList = new LinkedList<>(list);
                    nextList.add(next);
                    queue.offer(nextList);
                }
            }
        }

        return paths;
    }
}
