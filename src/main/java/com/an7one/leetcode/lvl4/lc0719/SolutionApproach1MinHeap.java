/**
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 * 
 * TLEed
 * 
 * Time Complexity: O(N * lg(N) + N * N * lg(N)) ~ O(N ^ 2 * lg(N))
 *  Sorting, costs O(N * lg(N))
 *  MinHeap, costs O(N ^ 2 * lg(N)), where one single round costs about O(N * lg(N)), and there are ~N rounds
 * 
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/242712/PriorityQueue-Nlog(n)-similar-to-merge-sort
 */
package com.an7one.leetcode.lvl4.lc0719;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach1MinHeap {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Math.abs(a[0] - a[1]) - Math.abs(b[0] - b[1]));
        
        for(int i = 0; i < nums.length - 1; i++){
            minHeap.add(new int[]{nums[i], nums[i + 1], i + 1});
        }
        
        int idx = 0;
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            if(++idx == k) return Math.abs(cur[0] - cur[1]);
            if(cur[2] == nums.length - 1) continue; // sequence ends
            minHeap.add(new int[]{cur[0], nums[cur[2] + 1], cur[2] + 1});
        }
        
        return 0;
    }
}