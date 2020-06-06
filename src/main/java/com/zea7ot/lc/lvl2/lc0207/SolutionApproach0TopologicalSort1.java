/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(numCourses + prerequisites.length)
 * Space Complexity:    O(numCourses ^ 2)
 */
package com.zea7ot.lc.lvl2.lc0207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0TopologicalSort1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] prerequisite : prerequisites){
            int ready = prerequisite[0], pre = prerequisite[1];
            indegree[pre]++;
            graph.get(ready).add(pre);
        }
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            for(int i = 0; i < graph.get(course).size(); i++){
                int cur = graph.get(course).get(i);
                indegree[cur]--;
                if(indegree[cur] == 0){
                    queue.add(cur);
                    count++;
                }
            }
        }
        
        return count == numCourses;
    }
}