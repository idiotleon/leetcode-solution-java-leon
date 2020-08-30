/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/510263/JavaC%2B%2BPython-Priority-Queue
 */
package com.zea7ot.leetcode.lvl3.lc1353;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0Greedy1 {
    public int maxEvents(int[][] events) {
        // sanity check
        if (events == null || events.length == 0)
            return 0;
        final int N = events.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int idx = 0, max = 0;
        int day = 0;
        while (!minHeap.isEmpty() || idx < N) {
            if (minHeap.isEmpty())
                day = events[idx][0];

            while (idx < N && events[idx][0] <= day)
                minHeap.offer(events[idx++][1]);

            minHeap.poll();
            ++max;
            ++day;
            while (!minHeap.isEmpty() && minHeap.peek() < day)
                minHeap.poll();
        }

        return max;
    }
}