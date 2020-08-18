/**
 * https://leetcode.com/problems/monotonic-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/monotonic-array/discuss/165889/C%2B%2BJavaPython-One-Pass-O(N)
 */
package com.zea7ot.leetcode.lvl2.lc0896;

public class SolutionApproach0OnePass1 {
    public boolean isMonotonic(int[] nums) {
        boolean increase = true;
        boolean decrease = true;
        
        final int N = nums.length;
        for(int i = 1; i < N; ++i){
            increase &= nums[i - 1] <= nums[i];
            decrease &= nums[i - 1] >= nums[i];
        }
        
        return increase || decrease;
    }
}