/**
 * https://leetcode.com/problems/last-stone-weight/
 * 
 * Time Complexity:     O(N) + O(N * lg(N)) ~ O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.polyg7ot.lc.lvl1.lc1046;

import java.util.PriorityQueue;

public class SolutionApproach0Simulation {
    public int lastStoneWeight(int[] stones) {
        // sanity check
        if(stones == null || stones.length == 0) return 0;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        
        for(int stone : stones){
            maxHeap.add(stone);
        }
        
        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int res = first - second;
            if(res != 0) maxHeap.offer(res);
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}