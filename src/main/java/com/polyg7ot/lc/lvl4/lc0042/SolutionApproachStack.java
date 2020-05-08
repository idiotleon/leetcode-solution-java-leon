/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * to maintain a "descreasing" stack:
 * 1. to contain indexes, instead of heights/values
 * 2. to maintain a decreasing order of heights in the stack
 * 
 * in another word, the stack always keeps 
 * the (index of) left taller (compare to cur) column
 * 
 * in another word, the stack.peek() always has (the index of) 
 * the most immediate left taller column 
 * 
 * to keep checking out once an increase of height has been discovered,
 * till the leftmost taller column (of the entire height array).
 */
package com.polyg7ot.lc.lvl4.lc0042;

import java.util.Stack;

public class SolutionApproachStack {
    public int trap(int[] height) {
        // sanity check
        if(height == null || height.length < 2) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int water = 0, idx = 0;
        final int L = height.length;
        while(idx < L){
            // as long as the incoming height is non-increasing
            if(stack.isEmpty() || height[idx] <= height[stack.peek()]){
                // to push it to the stack as candidates as left tallers columns
                stack.push(idx++);
            }else{  // once a concave has been found (meaning height starts to increase)
                int idxConcave = stack.pop();  // the bottom (of the concave)
                if(!stack.isEmpty()){
                    // to find the smaller height of the left and right sides
                    int minHeight = Math.min(height[stack.peek()], height[idx]);
                    // to calculate the area
                    water += (minHeight - height[idxConcave]) * (idx - stack.peek() - 1);
                }
            }
        }
        
        return water;
    }
}