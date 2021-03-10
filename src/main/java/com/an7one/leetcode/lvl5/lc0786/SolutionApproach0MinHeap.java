/**
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/
 * 
 * Time Complexity: O((N + K) * lg(N))
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378
 *  https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115486/Java-AC-O(max(nk)-*-logn)-Short-Easy-PriorityQueue
 */
package com.an7one.leetcode.lvl5.lc0786;

import java.util.PriorityQueue;

public class SolutionApproach0MinHeap {
    public int[] kthSmallestPrimeFraction(int[] nums, int K) {
        // sanity check
        if(nums == null || nums.length == 0) return new int[0];

        final int N = nums.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) 
            -> nums[a[0]] * nums[N - 1 - b[1]] - nums[N - 1 - a[1]] * nums[b[0]]);
        
        for(int i = 0; i < N; i++){
            minHeap.offer(new int[]{i, 0});
        }
        
        while(--K > 0){
            int[] p = minHeap.poll();
            
            if(++p[1] < N){
                minHeap.offer(p);
            }
        }
        
        return new int[]{nums[minHeap.peek()[0]], nums[N - 1 - minHeap.peek()[1]]};
    }
}