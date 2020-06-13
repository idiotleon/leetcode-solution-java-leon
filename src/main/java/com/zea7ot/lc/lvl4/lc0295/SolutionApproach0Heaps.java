/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * Time Complexities:
 *  addNum:     O(lg(N))
 *  findMedian: O(1)
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find
 */
package com.zea7ot.lc.lvl4.lc0295;

import java.util.PriorityQueue;

public class SolutionApproach0Heaps {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean isEven;

    /** initialize your data structure here. */
    public SolutionApproach0Heaps() {
        this.small = new PriorityQueue<Integer>((a, b) -> b - a);
        this.large = new PriorityQueue<Integer>();
        this.isEven = true;
    }
    
    public void addNum(int num) {
        if(isEven){
            large.offer(num);
            small.offer(large.poll());
        }else{
            small.offer(num);
            large.offer(small.poll());
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        if(isEven) return (small.peek() + large.peek()) / 2.0;
        else return small.peek();
    }
}