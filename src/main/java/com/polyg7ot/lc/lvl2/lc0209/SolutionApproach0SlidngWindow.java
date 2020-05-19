/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */
package com.polyg7ot.lc.lvl2.lc0209;

public class SolutionApproach0SlidngWindow {
    public int minSubArrayLen(int s, int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        int ans = Integer.MAX_VALUE, sum = 0, left = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= s){
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
