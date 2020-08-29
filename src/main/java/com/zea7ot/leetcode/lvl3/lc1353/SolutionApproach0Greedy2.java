/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 * 
 * Time Complexity:     O(N * lg(N)) + O(RANGE)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/510263/JavaC%2B%2BPython-Priority-Queue
 */
package com.zea7ot.leetcode.lvl3.lc1353;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0Greedy2 {
    public int maxEvents(int[][] events) {
        // sanity check
        if (events == null || events.length == 0)
            return 0;
        final int N = events.length;
        final int RANGE = (int) 1e5 + 1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int idx = 0, max = 0;
        for (int d = 1; d < RANGE; ++d) {
            while (!minHeap.isEmpty() && minHeap.peek() < d)
                minHeap.poll();

            while (idx < N && events[idx][0] == d)
                minHeap.offer(events[idx++][1]);

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                ++max;
            }
        }

        return max;
    }
}