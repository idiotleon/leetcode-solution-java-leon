/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/
 * 
 * Time Complexity:     O(NR * NC * lg(NC))
 * Space Complexity:    O(NC)
 * 
 * references:
 *  https://leetcode.com/problems/minimum-falling-path-sum-ii/discuss/451273/Python-DP-O(MN)
 */
package com.idiotleon.leetcode.lvl4.lc1289;

import java.util.PriorityQueue;

public class SolutionApproach0MinHeap {
    public int minFallingPathSum(int[][] nums) {
        // sanity check
        if(nums == null || nums.length == 0 || nums[0].length == 0) return 0;
        
        final int NR = nums.length, NC = nums[0].length;
        for(int row = 1; row < NR; ++row){
            PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
            for(int col = 0; col < NC; ++col)
                minHeap.offer(nums[row - 1][col]);
            
            int firstSmallest = minHeap.poll();
            int secondSmallest = minHeap.poll();
            for(int col = 0; col < NC; ++col){
                if(nums[row - 1][col] == firstSmallest){
                    nums[row][col] = nums[row][col] + secondSmallest;
                }else{
                    nums[row][col] = nums[row][col] + firstSmallest;
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col < NC; ++col)
            ans = Math.min(ans, nums[NR - 1][col]);
        
        return ans;
    }
}