/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-product-subarray/discuss/183483/In-Python-it-can-be-more-concise-PythonC%2B%2BJava
 */
package com.zea7ot.leetcode.lvl3.lc0152;

public class SolutionApproach0TwoPointers {
    public int maxProduct(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

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