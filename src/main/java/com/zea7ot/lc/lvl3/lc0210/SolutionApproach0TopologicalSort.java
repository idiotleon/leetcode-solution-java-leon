/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * Time Complexity:     O(numCourses + prerequisites.length)
 * Space Complexity:    O(numCourses)
 */
package com.zea7ot.lc.lvl3.lc0210;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0TopologicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // sanity check
        if(numCourses <= 0) return new int[0];
        
        int[] counts = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            counts[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
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