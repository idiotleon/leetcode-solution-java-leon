/**
 * https://leetcode.com/problems/alien-dictionary/
 */
package com.idiotleon.leetcode.lvl4.lc0269;

import java.util.Arrays;

public class SolutionApproach1DFS {
    private static final int N = 26;

    public String alienOrder(String[] words) {
        // sanity check
        if (words == null || words.length == 0)
            return "";

        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];

        // to build up the graph
        buildGraph(words, adj, visited);

        // DFS
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (!dfs(adj, visited, builder, i))
                    return "";
            }
        }

        return builder.reverse().toString();
    }

    private boolean dfs(boolean[][] adj, int[] visited, StringBuilder builder, int i) {
        visited[i] = 1; // 1 - being visited
        for (int j = 0; j < N; j++) {
            if (adj[i][j]) {
                if (visited[j] == 1)
                    return false; // 1 => 1, cycle
                if (visited[j] == 0) { // 0 - not yet visited
                    if (!dfs(adj, visited, builder, j)) {
                        return false;
                    }
                }
            }
        }

        visited[i] = 2; // 2 - visited
        builder.append((char) (i + 'a'));
        return true;
    }

    private void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1); // -1 - not even exist
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray())
                visited[c - 'a'] = 0;
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                if (!w1.equals(w2) && w1.startsWith(w2)) {
                    Arrays.fill(visited, 2);
                    return;
                }

                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
}