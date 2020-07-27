/**
 * https://leetcode.com/problems/monotonic-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/monotonic-array/discuss/165889/C++JavaPython-One-Pass-O(N)/171973
 */
package com.zea7ot.lc.lvl2.lc0896;

public class SolutionApproach0OnePass {
    public boolean isMonotonic(int[] nums) {
        boolean increase = false;
        boolean decrease = false;
        
        final int N = nums.length;
        
        for(int i = 1; i < N; ++i){
            if(nums[i] < nums[i - 1])
                decrease = true;
            
            if(nums[i] > nums[i - 1])
                increase = true;
        }
        
        return increase && decrease ? false : true;
    }
}