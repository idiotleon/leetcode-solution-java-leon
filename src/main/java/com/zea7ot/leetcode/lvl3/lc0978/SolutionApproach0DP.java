/**
 * https://leetcode.com/problems/longest-turbulent-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-turbulent-subarray/discuss/221935/Java-O(N)-time-O(1)-space
 */
package com.zea7ot.leetcode.lvl3.lc0978;

public class SolutionApproach0DP {
    public int maxTurbulenceSize(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int inc = 1, dec = 1, ans = 1;
        for(int i = 1; i < N; i++){
            if(nums[i] < nums[i - 1]){
                dec = inc + 1;
                inc = 1;
            }else if(nums[i] > nums[i - 1]){
                inc = dec + 1;
                dec = 1;
            }else{
                inc = 1;
                dec = 1;
            }
            
            ans = Math.max(ans, Math.max(dec, inc));
        }
        
        return ans;
    }
}