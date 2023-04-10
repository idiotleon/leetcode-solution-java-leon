/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * Time Complexities:     
 *  `addNum(int num)`:  O(lg(N))
 *  `findMedian()`:     O(1)
 * 
 * Space Complexity:    O(NUM(addNum()))
 */
package com.idiotleon.leetcode.lvl4.lc0295;

import java.util.PriorityQueue;

public class SolutionApproach0Heaps {
    // max heap
    private PriorityQueue<Integer> small;
    // min heap
    private PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public SolutionApproach0Heaps() {
        this.small = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        this.large = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if (small.size() <= large.size()) {
            large.add(num);
            small.add(large.poll());
        } else {
            small.add(num);
            large.add(small.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size())
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}