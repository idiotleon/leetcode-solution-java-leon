/**
 * https://leetcode.com/problems/number-of-recent-calls/
 * 
 * Time Complexity:     O(min(N, 3000))
 *  N, number of pings
 * 
 * Space Complexity:    O(min(N, 3000))
 * 
 * References:
 *  https://leetcode.com/problems/number-of-recent-calls/discuss/189239/JavaPython-3-Five-solutions%3A-TreeMap-TreeSet-ArrayList-Queue-Circular-List.
 */
package com.an7one.leetcode.ood.lvl2.lc0933;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach1Queue {
    private Deque<Integer> queue;

    public SolutionApproach1Queue() {
        this.queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}
