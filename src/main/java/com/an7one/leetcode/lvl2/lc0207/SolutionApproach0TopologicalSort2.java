package com.an7one.leetcode.lvl2.lc0207;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/course-schedule/">Description</a>
 *
 * Time Complexity:     O(V + E) ~ O(`numCourses` + `prerequisites.length`)
 * Space Complexity:    O(`numCourses` ^ 2)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TopologicalSort2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for(int[] prerequisite : prerequisites){
            int ready = prerequisite[0];
            int pre = prerequisite[1];
            
            if(matrix[pre][ready] == 0){ // to avoid duplicate cases
                indegree[ready]++; 
            }
            matrix[pre][ready] = 1;
        }
        
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.addLast(i);
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            ++count;
            for(int i = 0; i < numCourses; i++){
                if(matrix[course][i] != 0){
                    if(--indegree[i] == 0){
                        queue.addLast(i);
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}