/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/149867/Simple-Java-using-pq-with-explanation
 */
package com.zea7ot.leetcode.lvl4.lc0871;

import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0Greedy2 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int curFarthest = startFuel, refuel = 0;
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        
        for(int[] station : stations){
            while(curFarthest < station[0]){
                if(maxHeap.isEmpty()) return -1;
                curFarthest += maxHeap.poll();
                refuel++;
            }
            maxHeap.offer(station[1]);
        }
        
        while(curFarthest < target){
            if(maxHeap.isEmpty()) return -1;
            curFarthest += maxHeap.poll();
            refuel++;
        }
        
        return refuel;
    }
}