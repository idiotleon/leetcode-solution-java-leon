/**
 * https://leetcode.com/problems/course-schedule/
 */
package com.null7ptr.lc.lvl2.lc0207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            for(int i = 0; i < graph[course].size(); i++){
                int cur = graph[course].get(i);
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