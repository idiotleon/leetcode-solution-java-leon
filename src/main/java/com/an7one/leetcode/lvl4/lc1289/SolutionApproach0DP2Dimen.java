/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-falling-path-sum-ii/discuss/451258/Simple-DP(Java)-Same-problem-as-Paint-House-2-(265)
 */
package com.an7one.leetcode.lvl4.lc1289;

public class SolutionApproach0DP2Dimen {
    public int minFallingPathSum(int[][] nums) {
        // sanity check
        if(nums == null || nums.length == 0 || nums[0].length == 0) return 0;
        
        final int NR = nums.length, NC = nums[0].length;
        for(int row = NR - 2; row >= 0; --row){
            for(int col = 0; col < NC; ++col){
                int min = Integer.MAX_VALUE;
                // values to the left
                for(int k = 0; k < col; ++k){
                    min = Math.min(min, nums[row + 1][k]);
                }
                
                // values to the right
                for(int k = col + 1; k < NC; k++){
                    min = Math.min(min, nums[row + 1][k]);
                }
                
                nums[row][col] += min;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col < NC; ++col)
            ans = Math.min(ans, nums[0][col]);
        
        return ans;
    }
}