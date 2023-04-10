/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/150310/JAVA-13ms-Greedy-with-PriorityQueue
 */
package com.idiotleon.leetcode.lvl4.lc0871;

import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0Greedy1 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        final int N = stations.length;
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        int refuel = 0;
        int distance = startFuel;
        int idx = 0;
        while(true){
            if(distance >= target) return refuel;
            while(idx < N && stations[idx][0] <= distance){
                maxHeap.offer(stations[idx++][1]);
            }
            if(maxHeap.isEmpty()) return -1;
            distance += maxHeap.poll();
            refuel++;
        }
    }
}