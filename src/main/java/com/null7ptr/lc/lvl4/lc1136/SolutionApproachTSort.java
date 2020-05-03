/**
 * https://leetcode.com/problems/parallel-courses/
 * 
 * Time Complexity: O(V + E) ~ O(N + relations.length)
 * Space Complexity: O(V + E) ~ O(N + relations.length)
 */
package com.null7ptr.lc.lvl4.lc1136;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SolutionApproachTSort {
    public int minimumSemesters(int N, int[][] relations) {
        // to align with 0-based index(es)
        for(int row = 0; row < relations.length; row++){
            for(int col = 0; col < relations[row].length; col++){
                --relations[row][col];
            }
        }
        
        // to build up the graph
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < N; i++){
            map.put(i, new HashSet<Integer>());
        }
        
        int[] indegrees = new int[N];
        for(int[] relation : relations){
            map.get(relation[0]).add(relation[1]);
            ++indegrees[relation[1]];
        }
        
        // to topological sort
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < N; i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        
        int semester = 0, count = 0;
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            semester++;
            
            for(int i = 0; i < SIZE; i++){
                int cur = queue.removeFirst();
                count++;
                
                for(int course : map.get(cur)){
                    if(--indegrees[course] == 0){
                        queue.add(course);
                    }   
                }
            }
        }
        
        // Cycle exists.
        if(count < N) return -1;
        return semester;
    }
}