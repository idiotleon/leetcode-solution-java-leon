/**
 * https://leetcode.com/problems/profitable-schemes/
 * 
 * Time Complexity:     O(K * P * G)
 * Space Complexity:    O(P * G)
 * 
 * 
 * if dp[i][*] is only dependent on dp[i][*]
 * Dimension/Space reduction with a temporary array:
 *  1. temp = copy of dp[i - 1]
 *  2. to update temp
 *  3. dp[i] = temp
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-879-profitable-schemes/
 */
package com.idiotleon.leetcode.lvl4.lc0879;

public class SolutionApproach0Knapsack2Dimen1 {
    
}