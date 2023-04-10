/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/130452/20ms-Java-PriorityQueue-with-Explanations/198049
 *  https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/130452/20ms-Java-PriorityQueue-with-Explanations
 */
package com.idiotleon.leetcode.lvl3.lc0659;

import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0MinHeap{
    public boolean isPossible(int[] nums) {
        Queue<Interval> minHeap = new PriorityQueue<Interval>((a, b) -> (a.end == b.end) ? a.len - b.len : a.end - b.end);
        
        for(int num : nums){
            while(!minHeap.isEmpty() && minHeap.peek().end + 1 < num){
                if(minHeap.poll().len < 3) return false;
            }
            
            if(minHeap.isEmpty() || minHeap.peek().end == num){
                minHeap.add(new Interval(num, num));
            }else{
                Interval interval = minHeap.poll();
                interval.end = num;
                interval.len += 1;
                minHeap.add(interval);
            }
        }
        
        while(!minHeap.isEmpty()){
            if(minHeap.poll().len < 3) return false;
        }
        
        return true;
    }
    
    private class Interval{
        protected int end;
        protected int len;
        
        protected Interval(int end, int len){
            this.end = end;
            this.len = len;
        }
    }
}