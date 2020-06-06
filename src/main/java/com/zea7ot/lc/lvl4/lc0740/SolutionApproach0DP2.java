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
package com.zea7ot.lc.lvl4.lc0740;

public class SolutionApproach0DP2 {
    public int deleteAndEarn(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = 10001;
        int[] sums = new int[N];
        
        for(int num : nums){
            sums[num] += num;
        }
        
        return rob(sums);
    }

    /**
     * the same method for 198. House Robber
     * @param sums
     * @return
     */
    private int rob(final int[] sums){
        int dp1 = 0, dp2 = 0;
        for(int i = 0; i < sums.length; i++){
            int dp = Math.max(dp2 + sums[i], dp1);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}