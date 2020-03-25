/**
 * https://leetcode.com/problems/course-schedule-ii/
 */
package main.java.lcidiot.lc0210;

import java.util.LinkedList;
import java.util.Queue;

class SolutionApproachBFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return new int[0];
        int[] ans = new int[numCourses], indegree = new int[numCourses];
        
        // indegree - how many prerequisites are required
        for(int i = 0; i < prerequisites.length; i++)
            indegree[prerequisites[i][0]]++;
        
        int index = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++)
            if(indegree[i] == 0){
                // to add the course to the order because of no prerequisites
                ans[index++] = i;
                queue.offer(i);
            }
        
        // how many courses require no prerequisites
        while(!queue.isEmpty()){
            int course = queue.poll();  // already finished this prerequisite course
            for(int i = 0; i < prerequisites.length; i++){
                int ready = prerequisites[i][0], pre = prerequisites[i][1];
                if(pre == course){
                    indegree[ready]--;
                    if(indegree[ready] == 0){
                        ans[index++] = ready;
                        queue.offer(ready);
                    }
                }
            }
        }
        
        return index == numCourses ? ans : new int[0];
    }
}