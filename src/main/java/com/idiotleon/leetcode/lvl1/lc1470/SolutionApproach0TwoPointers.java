/**
 * @author: Leon
 * 
 * https://leetcode.com/problems/shuffle-the-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.idiotleon.leetcode.lvl1.lc1470;

public class SolutionApproach0TwoPointers {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        
        int idx1 = 0, idx2 = n, idx = 0;
        
        while(idx < 2 * n){
            if(idx % 2 == 0){
                ans[idx++] = nums[idx1++];
            }else{
                ans[idx++] = nums[idx2++];
            }
        }
        
        return ans;
    }
}