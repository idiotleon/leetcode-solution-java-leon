/**
 * https://leetcode.com/problems/global-and-local-inversions/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/global-and-local-inversions/discuss/113644/C%2B%2BJavaPython-Easy-and-Concise-Solution
 */
package com.an7one.leetcode.lvl3.lc0775;

public class SolutionApproach0Greedy1 {
    public boolean isIdealPermutation(int[] nums) {
        final int N = nums.length;
        int max = 0;
        
        for(int i = 0; i < N - 2; i++){
            max = Math.max(max, nums[i]);
            if(max > nums[i + 2]) return false;
        }
        
        return true;
    }
}