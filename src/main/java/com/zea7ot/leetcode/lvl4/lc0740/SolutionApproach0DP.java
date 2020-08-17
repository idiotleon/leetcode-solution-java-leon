/**
 * https://leetcode.com/problems/delete-and-earn/
 * 
 * Time Complexity:     O(N + R) + O(R) ~ O(N + R)
 *  N, the Number of elements in the input array
 *  R, the Range of the value of each integer element, which, in this case, is 10001,
 *      and can be optimized to the max value in the array, at an extra cost of O(N)
 * 
 * Spaec Complexity:    O(R)
 * 
 * References:
 *  https://leetcode.com/problems/delete-and-earn/discuss/109895/JavaC%2B%2B-Clean-Code-with-Explanation
 *  https://www.youtube.com/watch?v=YzZd-bsMthk
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-740-delete-and-earn/
 */
package com.zea7ot.leetcode.lvl4.lc0740;

public class SolutionApproach0DP {
    public int deleteAndEarn(int[] nums) {        
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int RANGE = 10001;
        int[] sums = new int[RANGE];
        
        for(int num : nums){
            sums[num] += num;
        }
        
        int take = 0, skip = 0;
        for(int i = 0; i < RANGE; ++i){
            int takei = skip + sums[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        
        return Math.max(take, skip);
    }
}