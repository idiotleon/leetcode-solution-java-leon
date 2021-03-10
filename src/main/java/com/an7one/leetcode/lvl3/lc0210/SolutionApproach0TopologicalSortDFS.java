/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * Time Complexity:     O(V + E) ~ O(numCourses + prerequisites.length)
 * Space Complexity:    O(V + E) ~ O(numCourses + prerequisites.length)
 * 
 * References:
 *  https://www.youtube.com/watch?v=M6SBePBMznU
 *  http://zxi.mytechroad.com/blog/graph/leetcode-210-course-schedule-ii/
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.an7one.leetcode.lvl3.lc0210;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TopologicalSortDFS {
    private static final int VISITING = 1;
    private static final int VISITED = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // sanity check
        if (numCourses <= 0)
            return new int[0];

        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] prerequisite : prerequisites) {
            int ready = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(ready).add(pre);
        }

        List<Integer> res = new ArrayList<Integer>();
        int[] visited = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, graph, visited, res)) {
                return new int[0];
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private boolean hasCycle(int vertex, List<List<Integer>> graph, int[] visited, List<Integer> res) {
        if (visited[vertex] == VISITING)
            return true; // there is a cycle
        if (visited[vertex] == VISITED)
            return false;

        visited[vertex] = VISITING;
        for (int next : graph.get(vertex)) {
            if (hasCycle(next, graph, visited, res)) {
                return true;
            }
        }

        visited[vertex] = VISITED;
        res.add(vertex);
        return false;
    }
}