/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * do not understand what memo(int[]) here means, 
 * nor feel it necessary: what is memoization here for?
 */
package com.zea7ot.lc.lvl3.lc0207;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach2DFSMemo {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // sanity check
        if(numCourses <= 0) return false;

        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        boolean[] memo = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(!hasNoCycle(i, visited, memo, graph)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasNoCycle(int course,
                               boolean[] visited, 
                               boolean[] memo,
                               List<List<Integer>> graph){
        if(visited[course]) return false;
        if(memo[course]) return true;
        
        visited[course] = true;
        for(int next : graph.get(course)){
            if(!hasNoCycle(next, visited, memo, graph)){
                return false;
            }
        }
        
        visited[course] = false;
        return memo[course] = true;
    }
}