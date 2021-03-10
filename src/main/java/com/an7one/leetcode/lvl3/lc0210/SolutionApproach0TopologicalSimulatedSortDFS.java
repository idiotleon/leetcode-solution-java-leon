/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * Time Complexity:     O(V + E) ~ O(numCourses) + O(prerequisites.length)
 * Space Complexity:    O(V) ~ O(numCourses)
 * 
 * References:
 *  https://www.youtube.com/watch?v=0LjVxtLnNOk
 */
package com.an7one.leetcode.lvl3.lc0210;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0TopologicalSimulatedSortDFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        // sanity check
        // please be noted that an empty prerequisites(int[][]) is valid
        if(numCourses <= 0) return ans;
        
        int[] counts = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            ++counts[prerequisite[0]];
        }
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(counts[i] == 0) {
                stack.push(i);
            }
        }
        
        int idx = 0;
        while(!stack.isEmpty()){
            int course = stack.pop();
            ans[idx++] = course;
            
            for(int[] prerequisite : prerequisites){
                if(prerequisite[1] == course){
                    if(--counts[prerequisite[0]] == 0){
                        stack.push(prerequisite[0]);
                    }
                }
            }
        }
        
        if(idx < numCourses) return new int[0];
        return ans;
    }
}