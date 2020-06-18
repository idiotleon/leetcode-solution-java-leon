/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * if the bottom being 0 means leaks.
 * only the concave of the bottom large than 0 can hold the water.
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * this is a one-pass solution
 */
package com.zea7ot.lc.lvl4.lc0042.followup;

import java.util.Stack;

public class SolutionApproach0MonoStack {
    public int trap(int[] height) {
        // sanity check
        if(height == null || height.length == 0) return 0;

        final int N = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int water = 0;
        int idx = 0;

        while(idx < N){
            if(height[idx] == 0){
                // to clear the stack
                // as if to deal with a new problem/array
                while(!stack.isEmpty()) stack.pop();
            }
            
            if(stack.isEmpty() || height[idx] <= height[stack.peek()]){
                stack.push(idx++);
            }else{
                int idxConcave = stack.pop();
                if(!stack.isEmpty()){
                    int minHeight = Math.min(height[idx], height[stack.peek()]);
                    water += (minHeight - height[idxConcave]) * (idx - stack.peek() - 1);
                }
            }
        }

        return water;
    }
}