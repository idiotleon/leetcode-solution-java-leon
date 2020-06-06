/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl3.lc0152;

public class SolutionApproachTwoPtrs {
    public int maxProduct(int[] nums) {
        final int N = nums.length;
        int ans = nums[0], left = 0, right = 0;
        
        for(int i = 0; i < N; i++){
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[N - 1 - i];
            ans = Math.max(ans, Math.max(left, right));
        }
        
        return ans;
    }
}