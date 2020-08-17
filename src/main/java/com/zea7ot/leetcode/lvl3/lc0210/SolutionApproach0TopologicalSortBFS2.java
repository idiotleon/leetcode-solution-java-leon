/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * Time Complexity:     O(numCourses + prerequisites.length)
 * Space Complexity:    O(numCourses ^ 2)
 */
package com.zea7ot.leetcode.lvl3.lc0210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0TopologicalSortBFS2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        // sanity check
        if(numCourses <= 0) return ans;
        
        int[] counts = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<Integer>());
        
        for(int[] prerequisite : prerequisites){
            int ready = prerequisite[0];
            int pre = prerequisite[1];
            
            ++counts[ready];
            graph.get(pre).add(ready);
        }
        
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for(int i = 0; i < numCourses; i++)
            if(counts[i] == 0)
                queue.offer(i);
        
        int idx = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans[idx++] = cur;
            
            for(int next : graph.get(cur)){
                if(--counts[next] == 0){
                    queue.offer(next);
                }
            }
        }
        
        return (idx < numCourses) ? new int[0] : ans;
    }
}