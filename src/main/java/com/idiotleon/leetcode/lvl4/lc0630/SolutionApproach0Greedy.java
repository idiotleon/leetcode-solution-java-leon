/**
 * https://leetcode.com/problems/course-schedule-iii/
 * 
 * Time Complexity:     O(N * lg(N))
 *  N, number of courses
 * 
 * Space Complexity:    O(N)
 *  N, number of courses
 * 
 * Reference:
 *  https://leetcode.com/problems/course-schedule-iii/discuss/104845/Short-Java-code-using-PriorityQueue
 *  https://leetcode.com/problems/course-schedule-iii/discuss/104845/Short-Java-code-using-PriorityQueue/202004
 */
package com.idiotleon.leetcode.lvl4.lc0630;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0Greedy {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        
        int time = 0;
        for(int[] course : courses){
            time += course[0];
            maxHeap.add(course[0]);
            if(time > course[1]){
                time -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }
}