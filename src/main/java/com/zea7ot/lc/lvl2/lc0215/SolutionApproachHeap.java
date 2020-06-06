/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
package com.zea7ot.lc.lvl2.lc0215;

import java.util.PriorityQueue;

public  class SolutionApproachHeap {
    public int findKthLargest(int[] nums, int k) {
        // to keep a min Heap
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1 , n2) -> n1 - n2);
        
        for(int num : nums){
            heap.add(num);
            if(heap.size() > k){
                heap.remove();
            }
        }
        
        return heap.remove();
    }
}