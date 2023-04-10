package com.idiotleon.leetcode.lvl2.lc0207;

import com.idiotleon.util.Constant;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/course-schedule/">Description</a>
 *
 * Time Complexity:     O(V + E) + O(`numCourses` + `prerequisites.length`)
 * Space Complexity:    O(`numCourses` ^ 2)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TopologicalSort1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < numCourses; ++i){
            graph.add(new ArrayList<>());
        }
        
        for(int[] prerequisite : prerequisites){
            int ready = prerequisite[0], pre = prerequisite[1];
            indegrees[pre]++;
            graph.get(ready).add(pre);
        }
        
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                queue.addLast(i);
                ++count;
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            for(int i = 0; i < graph.get(course).size(); i++){
                int cur = graph.get(course).get(i);
                --indegrees[cur];
                if(indegrees[cur] == 0){
                    queue.addLast(cur);
                    ++count;
                }
            }
        }
        
        return count == numCourses;
    }
}