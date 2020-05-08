/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Time complexity : O(n)O(n). nn numbers are pushed and popped.
 * Space complexity : O(n)O(n). Stack is used.
 */
package com.polyg7ot.lc.lvl4.lc0084;

import java.util.Stack;

public class SolutionApproachStack1 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length; ++i){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            
            stack.push(i);
        }
        
        while(stack.peek() != -1){
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        
        return maxArea;
    }
}