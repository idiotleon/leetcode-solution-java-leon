/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/294025/Java-Simple-Code-Greedy
 */
package com.an7one.leetcode.lvl4.lc0871;

import java.util.PriorityQueue;

public class SolutionApproach0Greedy {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target)
            return 0;

        final int N = stations.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int idx = 0;
        int refuel = 0;
        int maxDistance = startFuel;

        while (maxDistance < target) {
            while (idx < N && stations[idx][0] <= maxDistance) {
                maxHeap.offer(stations[idx][1]);
                idx++;
            }

            if (maxHeap.isEmpty())
                return -1;

            maxDistance += maxHeap.poll();
            ++refuel;
        }

        return refuel;
    }
}