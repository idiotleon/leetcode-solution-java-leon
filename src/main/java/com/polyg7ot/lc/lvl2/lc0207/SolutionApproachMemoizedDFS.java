/**
 * https://leetcode.com/problems/course-schedule/
 */
package com.polyg7ot.lc.lvl2.lc0207;

import java.util.ArrayList;

public class SolutionApproachMemoizedDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        boolean[] memo = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(!dfs(graph, visited, i, memo)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int course, boolean[] memo){
        if(visited[course]) return false;
        if(memo[course]) return true;
        
        visited[course] = true;
        for(int i = 0; i < graph[course].size(); i++){
            if(!dfs(graph, visited, graph[course].get(i), memo)){
                return false;
            }
        }
        
        visited[course] = false;
        memo[course] = true;
        return true;
    }
}