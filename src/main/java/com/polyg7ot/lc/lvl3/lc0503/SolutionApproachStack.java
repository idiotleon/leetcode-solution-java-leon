/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * to maintain a "non-increasing" stack
 * 1. the contents are indexes, instead of values
 * 2. the values/elements, accessed by those indexes, are non-increasing
 */
package com.polyg7ot.lc.lvl3.lc0503;

import java.util.Arrays;
import java.util.Stack;

public class SolutionApproachStack {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        
        final int L = nums.length;
        int[] ans = new int[L];
        Arrays.fill(ans, -1);
        
        Stack<Integer> idxStack = new Stack<Integer>();
        
        int idx = 0;
        while(idx < 2 * L){
            while(!idxStack.isEmpty() && nums[idxStack.peek()] < nums[idx % L]){
                ans[idxStack.pop()] = nums[idx % L];
            }
            
            idxStack.add(idx % L);
            
            idx++;
        }
        
        return ans;
    }
}