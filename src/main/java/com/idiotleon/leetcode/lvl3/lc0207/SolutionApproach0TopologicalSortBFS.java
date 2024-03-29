/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(`numCourses` + `prerequisites.length`)
 * Space Complexity     O(`numCourses`)
 * 
 * References:
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.idiotleon.leetcode.lvl3.lc0207;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0TopologicalSortBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            ++counts[prerequisite[1]];
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (counts[i] == 0) {
                queue.offer(i);
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ++idx;

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == course) {
                    if (--counts[prerequisite[1]] == 0) {
                        queue.offer(prerequisite[1]);
                    }
                }
            }
        }

        return idx == numCourses;
    }
}