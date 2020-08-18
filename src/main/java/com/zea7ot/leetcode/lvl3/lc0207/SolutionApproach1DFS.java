/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(V + E) ~ O(numCourses, prerequisites.length)
 * Space Complexity:    O(V) ~ O(numCourses)
 * 
 * If a vertex reached has already been in the recursion stack, there must be a cycle.
 * The edge that connects the current vertex to the vertext in the recursion stack is a back edge.
 * 
 * Since it is a directed graph, each edge has its direction.
 * Thus visited(boolean[]) alone cannot be solely relied on to detect cycle.
 * e.g.[[0,1],[1,2],[0,2]]
 * 
 * The visited(boolean[]) stops the search, returning false,
 * were a previously visited node visited again.
 * 
 * References:
 *  https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.zea7ot.leetcode.lvl3.lc0207;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach1DFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++) 
            graph.add(new ArrayList<Integer>());
        
        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(isCyclic(i, 
                        new boolean[numCourses], 
                        new boolean[numCourses], 
                        graph)) 
                return false;
        }

        return true;
    }
    
    private boolean isCyclic(int start, 
                             boolean[] visited, 
                             boolean[] recStack, 
                             List<List<Integer>> graph){
        
        if(recStack[start]) return true;
        if(visited[start]) return false;
        
        visited[start] = true;
        recStack[start] = true;
        
        for(int next : graph.get(start)){
            if(isCyclic(next, visited, recStack, graph))
                return true;
        }
        
        recStack[start] = false;
        return false;
    }
}