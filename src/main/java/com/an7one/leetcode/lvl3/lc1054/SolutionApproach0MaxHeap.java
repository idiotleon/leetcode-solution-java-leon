/**
 * https://leetcode.com/problems/distant-barcodes/
 * 
 * Time Complexity:     O(N * lg(N))
 *  N, the length of barcodes
 * 
 * Space Complexity:    O(N)
 *  N, the length of barcodes
 * 
 * References:
 *  https://leetcode.com/problems/distant-barcodes/discuss/299227/Java-Solution-Using-PriorityQueue-Similar-to-K-Distance-Apart-Question-where-K-2/281134
 *  https://leetcode.com/problems/distant-barcodes/discuss/299227/Java-Solution-Using-PriorityQueue-Similar-to-K-Distance-Apart-Question-where-K-2
 */
package com.an7one.leetcode.lvl3.lc1054;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0MaxHeap {
    public int[] rearrangeBarcodes(int[] barcodes) {
        // sanity check
        if(barcodes == null || barcodes.length == 0) return new int[0];

        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int barcode : barcodes){
            freq.put(barcode, freq.getOrDefault(barcode, 0) + 1);
        }

        Queue<Node> maxHeap = new PriorityQueue<Node>((a, b) -> Integer.compare(b.count, a.count));
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            Node node = new Node(entry.getKey(), entry.getValue());
            maxHeap.offer(node);
        }
        
        final int N = barcodes.length;
        int[] ans = new int[N];
        int idx = 0;
        while(!maxHeap.isEmpty()){
            Node top = maxHeap.poll();
            while(top.count-- > 0){
                ans[idx] = top.val;
                idx += 2;
                if(idx >= N) idx = 1;
            }
        }

        return ans;
    }
    
    private class Node{
        protected int val;
        protected int count;
        protected Node(int val, int count){
            this.val = val;
            this.count = count; 
        }
    }
}