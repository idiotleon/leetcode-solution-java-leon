/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * Time Complexity:     O(V + E) ~ O(numCourses + prerequisites.length)
 * Space Complexity:    O(V) ~ O(numCourses)
 * 
 * References:
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.zea7ot.lc.lvl3.lc0210;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0TopologicalSortBFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // sanity check
        // please be noted that an empty prerequisites(int[][]) is valid
        if(numCourses <= 0) return new int[0];
        
        int[] counts = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            counts[prerequisite[0]]++;
        }
        
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(counts[i] == 0){
                queue.offer(i);
            }
        }
        
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            ans[idx++] = course;
            
            for(int[] prerequisite : prerequisites){
                if(prerequisite[1] == course){
                    if(--counts[prerequisite[0]] == 0){
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }
        
        if(idx < numCourses) return new int[0];
        
        return ans;
    }
}