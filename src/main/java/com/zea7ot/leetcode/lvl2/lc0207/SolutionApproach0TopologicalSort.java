/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(numCourses, prerequisites.length)
 * Space Complexity:    O(numCourses)
 */
package com.zea7ot.leetcode.lvl2.lc0207;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0TopologicalSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        
        for(int[] prerequisite : prerequisites){
            ++counts[prerequisite[1]];
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(counts[i] == 0){
                queue.offer(i);
            }
        }
        
        int idx = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            idx++;
            
            for(int[] prerequisite : prerequisites){
                if(prerequisite[0] == course){
                    if(--counts[prerequisite[1]] == 0){
                        queue.offer(prerequisite[1]);
                    }
                }
            }
        }
        
        return idx == numCourses;
    }
}