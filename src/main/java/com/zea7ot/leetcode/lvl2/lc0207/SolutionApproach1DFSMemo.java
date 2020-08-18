/**
 * https://leetcode.com/problems/course-schedule/
 */
package com.zea7ot.leetcode.lvl2.lc0207;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach1DFSMemo {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        boolean[] memo = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int ready = prerequisites[i][0], pre = prerequisites[i][1];
            graph.get(ready).add(pre);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(!dfs(graph, visited, i, memo)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int course, boolean[] memo){
        if(visited[course]) return false;
        if(memo[course]) return true;
        
        visited[course] = true;
        for(int i = 0; i < graph.get(course).size(); i++){
            if(!dfs(graph, visited, graph.get(course).get(i), memo)){
                return false;
            }
        }
        
        visited[course] = false;
        memo[course] = true;
        return true;
    }
}