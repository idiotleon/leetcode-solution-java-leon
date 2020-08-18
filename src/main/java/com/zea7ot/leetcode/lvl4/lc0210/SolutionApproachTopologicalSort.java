/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * https://leetcode.com/problems/course-schedule-ii/discuss/190393/Topological-Sort-Template-General-Approach!!
 */
package com.zea7ot.leetcode.lvl4.lc0210;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachTopologicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        // sanity check
        if(numCourses == 0) return ans;
        
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            
            if(matrix[pre][ready] == 0){
                indegree[ready]++;
            }
                
            matrix[pre][ready] = 1;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int index = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            ans[index++] = course;
            for(int i = 0; i < numCourses; i++){
                if(matrix[course][i] != 0){
                    if(--indegree[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }
        
        if(index < numCourses) return new int[]{};
        
        return ans;
    }
}