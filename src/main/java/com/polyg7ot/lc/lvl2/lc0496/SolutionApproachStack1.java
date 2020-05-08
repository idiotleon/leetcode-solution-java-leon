/**
 * https://leetcode.com/problems/next-greater-element-i/
 * 
 * Space Complexity: O(N)
 * Time Complexity: O(N)
 * 
 * to maintain a strictly increasing stack
 * 1. the contents are actual elements/values, NOT indexes
 * 2. the elements/values are put in a strictly increasing order
 */
package com.polyg7ot.lc.lvl2.lc0496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SolutionApproachStack1 {
    public int[] nextGreaterElement(int[] sub, int[] nums) {
        // sanity check
        if(sub == null || sub.length == 0 || nums == null || nums.length < sub.length) return new int[0];

        int[] ans = new int[sub.length];
        
        Stack<Integer> valStack = new Stack<Integer>();
        // value to index
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        
        // from end to start
        for(int i = nums.length - 1; i >= 0; i--){
            // if a greater (than the top of the stack) value has been found ***from end to start***
            // all previous smaller values should be poped out,
            // after which the top of the stack keeps the best till now candidate as the "next greater" value.
            while(!valStack.isEmpty() && valStack.peek() <= nums[i]){
                valStack.pop();
            }
            
            if(valStack.isEmpty()) idxMap.put(nums[i], -1);
            else idxMap.put(nums[i], valStack.peek());
            
            valStack.push(nums[i]);
        }
        
        for(int i = 0; i < sub.length; i++){
            ans[i] = idxMap.get(sub[i]);
        }
        
        return ans;
    }
}