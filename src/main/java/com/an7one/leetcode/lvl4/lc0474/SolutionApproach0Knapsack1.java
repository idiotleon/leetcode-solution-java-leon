/**
 * https://leetcode.com/problems/ones-and-zeroes/
 * 
 * Time Complexity:     O(N * m * n)
 * Space Complexity:    O(m * n)
 * 
 * Reference:
 *  https://leetcode.com/problems/ones-and-zeroes/discuss/95807/0-1-knapsack-detailed-explanation.
 */
package com.an7one.leetcode.lvl4.lc0474;

public class SolutionApproach0Knapsack1 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        int[] nums = {0, 0};
        for(String str : strs){
            nums = count(str);
            for(int j = m; j >= nums[0]; --j){
                for(int k = n; k >= nums[1]; --k){
                    if(j >= nums[0] && k >= nums[1]){
                        dp[j][k] = Math.max(dp[j][k], dp[j - nums[0]][k - nums[1]] + 1);
                    }
                }
            }
        }
        
        return dp[m][n];
    }
    
    private int[] count(String str){
        int[] res = new int[2];
        
        for(char ch : str.toCharArray()){
            if(ch == '0') ++res[0];
            else if(ch == '1') ++res[1];
        }
        
        return res;
    }
}