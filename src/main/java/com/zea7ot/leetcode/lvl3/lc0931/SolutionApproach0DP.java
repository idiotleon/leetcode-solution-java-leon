/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-falling-path-sum/discuss/186666/C%2B%2BJava-4-lines-DP
 */
package com.zea7ot.leetcode.lvl3.lc0931;

public class SolutionApproach0DP {
    public int minFallingPathSum(int[][] nums) {
        // sanity check
        if(nums == null || nums.length == 0 || nums[0].length == 0) return 0;

        final int NR = nums.length, NC = nums[0].length;
        
        for(int row = 1; row < NR; row++){
            for(int col = 0; col < NC; col++){
                nums[row][col] += Math.min(nums[row - 1][col], Math.min(nums[row - 1][Math.max(0, col - 1)], nums[row - 1][Math.min(NC - 1, col + 1)]));
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int col = 0; col < NC; col++){
            min = Math.min(min, nums[NR - 1][col]);
        }
        return min;
    }
}