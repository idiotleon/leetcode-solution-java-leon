/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(V + E) ~ O(numCourses + prerequisites.length)
 * Space Complexity:    O(V) ~ O(numCourses)
 * 
 * References:
 *  https://www.youtube.com/watch?v=rKQaZuoUR4M&feature=emb_rel_pause
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/CycleInDirectedGraph.java
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.zea7ot.lc.lvl3.lc0207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0ColoringDFS1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Set<Integer> whiteSet = new HashSet<Integer>();
        Set<Integer> graySet = new HashSet<Integer>();
        Set<Integer> blackSet = new HashSet<Integer>();
        
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            whiteSet.add(i);
            graph.put(i, new ArrayList<Integer>());
        }
        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        while(!whiteSet.isEmpty()){
            int vertex = whiteSet.iterator().next();
            if(hasCycle(graph, vertex, whiteSet, graySet, blackSet)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(Map<Integer, List<Integer>> graph,
                            int vertex,
                            Set<Integer> whiteSet, 
                            Set<Integer> graySet, 
                            Set<Integer> blackSet){
        move(vertex, whiteSet, graySet);
        for(int next : graph.get(vertex)){
            
            if(blackSet.contains(next)) continue;
            
            if(graySet.contains(next)) return true;
            
            if(hasCycle(graph, next, whiteSet, graySet, blackSet)) return true;
            
        }
        move(vertex, graySet, blackSet);
        return false;
    }
    
    private void move(int vertex, Set<Integer> sourceSet, Set<Integer> destinationSet){
        sourceSet.remove(vertex);
        destinationSet.add(vertex);
    }
}