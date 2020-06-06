/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl3.lc0503;

import java.util.Stack;

public class SolutionApproachStack1 {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        
        final int L = nums.length;
        int[] ans = new int[L];
        
        Stack<Integer> idxStack = new Stack<Integer>();
        int idx = 0;
        
        while(idx < 2 * L){
            while(!idxStack.isEmpty() && nums[idxStack.peek()] < nums[idx % L]){
                ans[idxStack.pop()] = nums[idx % L];
            }
            
            if(idx < L){
                idxStack.add(idx);
                ans[idx] = nums[idx];
            }
            
            idx++;
        }
        
        while(!idxStack.isEmpty()){
            ans[idxStack.pop()] = -1;
        }
        
        return ans;
    }
}