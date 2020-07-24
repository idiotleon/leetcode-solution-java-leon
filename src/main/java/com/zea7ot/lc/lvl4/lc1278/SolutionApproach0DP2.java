/**
 * https://leetcode.com/problems/palindrome-partitioning-iii/
 * 
 * 
 * State / Subproblems:
 *  1. length `i`: relies on length `j` (j < i)
 *  2. groups `k`: relies on `k - 1` groups
 * 
 * `dp[i][k]`, min cost to make `k` strings using the first `i` letters
 *  for each subproblem, it takes O(L) time to try all possible partitions.
 * 
 * Transition:
 *  dp[i][k] = min{dp[j][k - 1] + cost(j + 1, i)}
 * 
 * Initialization: 
 *  dp[i][1] = cost(0, i)
 *      dp[i][1], to take all `i`s into ONE partition/group
 * 
 * Answer:
 *  dp[L - 1][K]
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=kD6ShM6jr3g
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1278-palindrome-partitioning-iii/
 * 
 */
package com.zea7ot.lc.lvl4.lc1278;

public class SolutionApproach0DP2 {
    
}