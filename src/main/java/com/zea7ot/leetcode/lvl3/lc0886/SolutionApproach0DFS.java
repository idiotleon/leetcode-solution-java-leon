/**
 * https://leetcode.com/problems/possible-bipartition/
 * 
 * Time Complexity:     O(V + E) ~ O(N + dislikes.length)
 * Space Complexity:    O(V + E) ~ O(N + dislikes.length)
 * 
 * References:
 *  https://leetcode.com/problems/possible-bipartition/discuss/158957/Java-DFS-solution
 */
package com.zea7ot.leetcode.lvl3.lc0886;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    private static final int NOT_YET_COLORED = 0;
    private static final int COLORED = 7;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        // sanity check
        if (N <= 0)
            return false;

        List<List<Integer>> graph = buildGraph(N, dislikes);

        int[] colors = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            if (colors[i] != NOT_YET_COLORED)
                continue;

            if (!isValid(i, COLORED, colors, graph))
                return false;
        }

        return true;
    }

    private boolean isValid(int cur, final int COLOR, int[] colors, List<List<Integer>> graph) {
        if (colors[cur] != NOT_YET_COLORED)
            return colors[cur] == COLOR;

        colors[cur] = COLOR;
        for (int next : graph.get(cur))
            if (!isValid(next, -COLOR, colors, graph))
                return false;

        return true;
    }

    private List<List<Integer>> buildGraph(final int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<Integer>());

        for (int[] dislike : dislikes) {
            int u = dislike[0], v = dislike[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}