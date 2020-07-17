/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl2.lc0347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0MinHeap {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(freqMap.get(a), freqMap.get(b)));
        for(int key : freqMap.keySet()){
            minHeap.offer(key);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        final int SIZE = minHeap.size();
        int[] ans = new int[SIZE];
        int idx = SIZE - 1;
        while(!minHeap.isEmpty()) ans[idx--] = minHeap.poll();
        return ans;
    }
}