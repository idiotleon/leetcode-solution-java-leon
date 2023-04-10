/**
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 * 
 * Time Complexity:     O(NR * NC * lg(NR))
 * Space Complexity:    O(NR)
 * 
 * References:
 *  https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/discuss/104893/Java-Code-using-PriorityQueue.-similar-to-merge-k-array
 */
package com.idiotleon.leetcode.lvl4.lc0632;

import java.util.List;
import java.util.PriorityQueue;

public class SolutionApproach0MinHeap {
    public int[] smallestRange(List<List<Integer>> nums) {
        // sanity check
        if(nums == null || nums.isEmpty()) return new int[0];
        
        final int N = nums.size();
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>((a, b) -> Integer.compare(a.value, b.value));
        
        int max = Integer.MIN_VALUE;
        for(int row = 0; row < N; row++){
            Element ele = new Element(row, 0, nums.get(row).get(0));
            minHeap.offer(ele);
            max = Math.max(max, nums.get(row).get(0));
        }
        
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while(minHeap.size() == N){
            Element cur = minHeap.poll();
            if(max - cur.value < range){
                range = max - cur.value;
                start = cur.value;
                end = max;
            }
            
            if(cur.col + 1 < nums.get(cur.row).size()){
                cur.col++;
                cur.value = nums.get(cur.row).get(cur.col);
                minHeap.offer(cur);
                if(cur.value > max) max = cur.value;
            }
        }
        
        return new int[] {start, end};
    }
    
    private class Element{
        protected int row;
        // the idx in the `row`th list
        protected int col;
        protected int value;
        
        protected Element(int row, int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}