/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(numCourses + prerequisites.length)
 * Space Complexity     O(numCourses ^ 2)
 * 
 * References:
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.idiotleon.leetcode.lvl3.lc0207;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0TopologicalSortBFS1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int ready = prerequisite[0];
            int pre = prerequisite[1];

            if (matrix[pre][ready] == 0) {
                ++indegree[ready];
            }

            matrix[pre][ready] = 1;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.removeFirst();
            ++count;

            for (int i = 0; i < numCourses; ++i) {
                if (matrix[course][i] == 1) {
                    if (--indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        return numCourses == count;
    }
}