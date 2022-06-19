package com.an7one.leetcode.lvl2.lc0207;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/course-schedule/">Description</a>
 *
 * Time Complexity:     O(V + E) ~ O(`numCourse` + `prerequisites.length`)
 * Space Complexity:    O(V + E) ~ O(`numCourse` + `prerequisites.length`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSMemo {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);

        boolean[] memo = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; ++i){
            if(!dfs(i, visited, graph, memo)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int course, boolean[] visited,  List<List<Integer>> graph, boolean[] memo){
        if(visited[course]) return false;
        if(memo[course]) return true;
        
        visited[course] = true;
        for(int i = 0; i < graph.get(course).size(); ++i){
            if(!dfs(graph.get(course).get(i), visited, graph, memo)){
                return false;
            }
        }
        
        visited[course] = false;
        memo[course] = true;
        return true;
    }

    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; ++i){
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int ready = prerequisite[0], pre = prerequisite[1];
            graph.get(ready).add(pre);
        }
        return graph;
    }
}