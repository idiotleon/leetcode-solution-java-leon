/**
 * https://leetcode.com/problems/next-greater-element-i/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * to maintain a strictly descreasing stack
 * 1. the contents of the stack are actual values/elements
 * 2. the elements are strickly descreasing
 */
package com.zea7ot.lc.lvl2.lc0496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SolutionApproachStack {
    public int[] nextGreaterElement(int[] sub, int[] nums) {
        // sanity check
        if(sub == null || sub.length == 0 || nums == null || nums.length < sub.length) return new int[0];

        // value to index
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        Stack<Integer> valStack = new Stack<Integer>();
        
        for(int num : nums){
            // once a greater value has been found, let's say, num
            while(!valStack.isEmpty() && valStack.peek() < num){
                // to pop out all smaller elements existing in the stack,
                // and their next greater values all are num
                idxMap.put(valStack.pop(), num);
            }
            
            valStack.push(num);
        }
        
        int[] ans = new int[sub.length];
        for(int i = 0; i < sub.length; i++){
            ans[i] = idxMap.getOrDefault(sub[i], -1);
        }
        return ans;
    }
}