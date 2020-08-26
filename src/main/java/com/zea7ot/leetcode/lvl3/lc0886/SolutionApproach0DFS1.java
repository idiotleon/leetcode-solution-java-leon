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

public class SolutionApproach0DFS1 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] dislike : dislikes) {
            graph[dislike[0] - 1][dislike[1] - 1] = 1;
            graph[dislike[1] - 1][dislike[0] - 1] = 1;
        }

        int[] groups = new int[N];
        for (int i = 0; i < N; ++i) {
            if (groups[i] == 0 && !dfs(i, 1, groups, graph)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int idx, int g, int[] groups, int[][] graph) {
        final int N = graph.length;
        groups[idx] = g;
        for (int i = 0; i < N; ++i) {
            if (graph[idx][i] == 1) {
                if (groups[i] == g)
                    return false;

                if (groups[i] == 0 && !dfs(i, -g, groups, graph)) {
                    return false;
                }
            }
        }

        return true;
    }
}