/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * Time Complexity:     O(V + E) ~ O(numCourses, prerequisites.length)
 * Space Complexity:    O(V) ~ O(numCourses)
 * 
 * References:
 *  https://www.youtube.com/watch?v=Qqgck2ijUjU
 *  https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 */
package com.an7one.leetcode.lvl3.lc0207;

import java.util.Stack;

public class SolutionApproach0TopologicalSortSimulatedDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            ++counts[prerequisite[0]];
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(counts[i] == 0){
                stack.push(i);
            }
        }
        
        int count = 0;
        while(!stack.isEmpty()){
            int course = stack.pop();
            count++;
            
            for(int[] prerequisite : prerequisites){
                if(prerequisite[1] == course){
                    if(--counts[prerequisite[0]] == 0){
                        stack.push(prerequisite[0]);
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}