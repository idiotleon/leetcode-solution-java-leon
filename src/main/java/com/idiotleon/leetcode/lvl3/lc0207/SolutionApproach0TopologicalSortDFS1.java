/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(V + E) ~ O(numCourses) + O(prerequisites.length)
 * Space Complexity:    O(V + E) ~ O(numCourses) + O(prerequisites.length)
 * 
 * References:
 *  https://www.youtube.com/watch?v=M6SBePBMznU
 *  http://zxi.mytechroad.com/blog/graph/leetcode-207-course-schedule/
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.idiotleon.leetcode.lvl3.lc0207;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TopologicalSortDFS1 {
    private static final int VISITING = 1;
    private static final int VISITED = 2;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // sanity check
        if(numCourses <= 0) return false;

        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        
        int[] visit = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!canFinish(i, visit, graph)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean canFinish(int course,
                              int[] visit, 
                              List<List<Integer>> graph){
        if(visit[course] == VISITING) return false;
        if(visit[course] == VISITED) return true;
        
        visit[course] = VISITING;
        
        for(int next : graph.get(course)){
            if(!canFinish(next, visit, graph)){
                return false;
            }
        }
        
        visit[course] = VISITED;
        return true;
    }
}