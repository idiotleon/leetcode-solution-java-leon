/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(`size`)
 */
package com.zea7ot.leetcode.lvl1.lc0346;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Queue {
    private Deque<Integer> queue;
    private final int CAPACITY;
    private int sum;

    /** Initialize your data structure here. */
    public SolutionApproach0Queue(int size) {
        this.queue = new ArrayDeque<Integer>();
        this.CAPACITY = size;
        this.sum = 0;
    }

    public double next(int val) {
        final int SIZE = queue.size();
        queue.offer(val);
        sum += val;

        if (SIZE < CAPACITY) {
            return (1.0) * sum / (SIZE + 1);
        } else {
            int cur = queue.poll();
            sum -= cur;
            return (1.0) * sum / CAPACITY;
        }
    }
}
