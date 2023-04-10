/**
 * https://leetcode.com/problems/longest-turbulent-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-turbulent-subarray/discuss/221929/C%2B%2BJava-6-lines-flip-the-sign
 */
package com.idiotleon.leetcode.lvl3.lc0978;

public class SolutionApproach0DP2 {
    public int maxTurbulenceSize(int[] nums) {
        // sanity check
        
        final int N = nums.length;
        int ans = 0;
        for(int i = 0, count = 0; i + 1 < N; ++i, count *= -1){
            if(nums[i] > nums[i + 1]) count = count > 0 ? count + 1 : 1;
            else if(nums[i] < nums[i + 1]) count = count < 0 ? count - 1 : -1;
            else count = 0;
            
            ans = Math.max(ans, Math.abs(count));
        }
        
        return ans + 1;
    }
}