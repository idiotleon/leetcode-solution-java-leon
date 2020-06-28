/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl4.lc0295;

import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0Heaps {
    private Queue<Integer> small;
    private Queue<Integer> large;

    /** initialize your data structure here. */
    public SolutionApproach0Heaps() {
        this.small = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        this.large = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(small.size() <= large.size()){
            large.add(num);
            small.add(large.poll());
        }else{
            small.add(num);
            large.add(small.poll());
        }
    }
    
    public double findMedian() {
        boolean isEven = (small.size() + large.size()) % 2 == 0;
        if(isEven) return (small.peek() + large.peek()) / 2.0;
        else return small.peek();
    }
}