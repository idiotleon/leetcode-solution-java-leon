/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * Time Complexity:     O(numCourses + prerequisites.length)
 * Space Complexity:    O(numCourses ^ 2)
 * 
 * References:
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.idiotleon.leetcode.lvl3.lc0210;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0TopologicalSortBFS1 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        // sanity check
        // please be noted that an empty prerequisites(int[][]) is valid
        if (numCourses <= 0)
            return ans;

        int[][] matrix = new int[numCourses][numCourses];
        int[] counts = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int ready = prerequisite[0];
            int pre = prerequisite[1];

            if (matrix[pre][ready] == 0) {
                ++counts[ready];
            }

            matrix[pre][ready] = 1;
        }

        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (counts[i] == 0) {
                queue.add(i);
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int course = queue.removeFirst();
            ans[idx++] = course;

            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] == 1) {
                    if (--counts[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        if (idx < numCourses)
            return new int[0];

        return ans;
    }
}