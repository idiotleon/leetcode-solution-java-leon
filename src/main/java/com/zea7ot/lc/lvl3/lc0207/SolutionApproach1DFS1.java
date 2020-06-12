/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(V + E) ~ O(numCourses + prerequisites.length)
 * Space Complexity:    O(V) ~ O(numCourses)
 * 
 * References:
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.zea7ot.lc.lvl3.lc0207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach1DFS1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int[] prerequisite : prerequisites){
            graph.putIfAbsent(prerequisite[1], new ArrayList<Integer>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(isCyclic(graph, i, new boolean[numCourses])) 
                return false;
        }

        return true;
    }
    
    private boolean isCyclic(Map<Integer, List<Integer>> graph, 
                             int start, 
                             boolean[] visited){
        
        if(!graph.containsKey(start)) return false;
        if(visited[start]) return true;
        visited[start] = true;
        
        for(int next : graph.get(start)){
            if(isCyclic(graph, next, visited))
                return true;
        }

        visited[start] = false;
        return false;
    }
}