/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
package com.polyg7ot.lc.lvl3.lc0210;

import java.util.LinkedList;

public class SolutionApproachTSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        if(numCourses <= 0) return ans;
        
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for(int[] prerequisite : prerequisites){
            int ready = prerequisite[0];
            int pre = prerequisite[1];
            
            if(matrix[pre][ready] == 0){
                ++indegree[ready];
            }
            
            matrix[pre][ready] = 1;
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        int idx = 0;
        while(!queue.isEmpty()){
            int course = queue.removeFirst();
            ans[idx++] = course;
            
            for(int i = 0; i < numCourses; i++){
                if(matrix[course][i] == 1){
                    if(--indegree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        
        if(idx < numCourses) return new int[0];
        
        return ans;
    }
}