/**
 * https://leetcode.com/problems/longest-turbulent-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-turbulent-subarray/discuss/221935/Java-O(N)-time-O(1)-space/253973
 */
package com.idiotleon.leetcode.lvl3.lc0978;

public class SolutionApproach0DP1 {
    public int maxTurbulenceSize(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        final int N = nums.length;
        int prev = 0, cur = 0, len = 1, ans = 1;
        for(int i = 1; i < N; i++){
            cur = Integer.compare(nums[i], nums[i - 1]);
            if(cur * prev == -1) len++;
            else if(cur == 0) len = 1;
            else len = 2;
            
            ans = Math.max(ans, len);
            prev = cur;
        }
        
        return ans;
    }
}