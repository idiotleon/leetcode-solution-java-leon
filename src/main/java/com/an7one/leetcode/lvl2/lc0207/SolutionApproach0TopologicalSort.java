package com.an7one.leetcode.lvl2.lc0207;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/course-schedule/">Description</a>
 *
 * Time Complexity:     O(E + V) ~ O(`numCourses` + `prerequisites.length`)
 * Space Complexity:    O(`numCourses`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TopologicalSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        
        for(int[] prerequisite : prerequisites){
            ++counts[prerequisite[1]];
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(counts[i] == 0){
                queue.addLast(i);
            }
        }
        
        int idx = 0;
        while(!queue.isEmpty()){
            int course = queue.removeFirst();
            idx++;
            
            for(int[] prerequisite : prerequisites){
                if(prerequisite[0] == course){
                    if(--counts[prerequisite[1]] == 0){
                        queue.addLast(prerequisite[1]);
                    }
                }
            }
        }
        
        return idx == numCourses;
    }
}