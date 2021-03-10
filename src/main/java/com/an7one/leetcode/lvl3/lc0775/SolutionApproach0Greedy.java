/**
 * https://leetcode.com/problems/global-and-local-inversions/
 * 
 * Time Complexity:     O(N)
 * Space Compleixty:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/global-and-local-inversions/discuss/150991/Logical-Thinking-with-Clear-Code
 *  http://zxi.mytechroad.com/blog/divide-and-conquer/leetcode-775-global-and-local-inversions/
 */
package com.an7one.leetcode.lvl3.lc0775;

public class SolutionApproach0Greedy {
    public boolean isIdealPermutation(int[] nums) {
        final int N = nums.length;
        for(int i = 0; i < N; i++){
            if(Math.abs(nums[i] - i) > 1) return false;
        }
        
        return true;
    }
}