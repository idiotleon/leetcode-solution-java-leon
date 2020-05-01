/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity: O(V + E)
 * Space Complexity O(V + E)
 */
package com.null7ptr.lc.lvl3.lc0207;

import java.util.LinkedList;

public class SolutionApproachTSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.removeFirst();
            count++;
            for(int i = 0; i < numCourses; i++){
                if(matrix[course][i] == 1){
                    if(--indegree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        
        return numCourses == count;
    }
}