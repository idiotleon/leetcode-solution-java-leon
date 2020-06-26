/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(V + E) ~ O(numCourses + prerequisites.length)
 * Space Complexity:    O(V) ~ O(numCourses)
 * 
 * References:
 *  https://www.youtube.com/watch?v=rKQaZuoUR4M&feature=emb_rel_pause
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/CycleInDirectedGraph.java
 */
package com.zea7ot.lc.lvl3.lc0207;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0ColoringDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Set<Integer> whiteSet = new HashSet<Integer>();
        Set<Integer> graySet = new HashSet<Integer>();
        Set<Integer> blackSet = new HashSet<Integer>();
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            whiteSet.add(i);
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        while(!whiteSet.isEmpty()){
            int vertex = whiteSet.iterator().next();
            if(hasCycle(vertex, whiteSet, graySet, blackSet, graph)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(int vertex,
                             Set<Integer> whiteSet,
                             Set<Integer> graySet,
                             Set<Integer> blackSet, 
                             List<List<Integer>> graph){
        move(vertex, whiteSet, graySet);
        for(int next : graph.get(vertex)){
            
            if(blackSet.contains(next)) continue;
            
            if(graySet.contains(next)) return true;
            
            if(hasCycle(next, whiteSet, graySet, blackSet, graph)) return true;
            
        }
        move(vertex, graySet, blackSet);
        return false;
    }
    
    private void move(int vertex, Set<Integer> sourceSet, Set<Integer> destinationSet){
        sourceSet.remove(vertex);
        destinationSet.add(vertex);
    }
}