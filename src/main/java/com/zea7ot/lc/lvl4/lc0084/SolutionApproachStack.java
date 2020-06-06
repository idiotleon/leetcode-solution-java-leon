/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * to maintain a "non-descreasing" stack
 * 1. the content of the stack is index(es)
 * 2. the elements/heights, accessed by indexes, are non-descreasing
 */
package com.zea7ot.lc.lvl4.lc0084;

import java.util.Stack;

public class SolutionApproachStack {
    public int largestRectangleArea(int[] heights) {
        // sanity check
        if(heights == null || heights.length == 0) return 0;
        
        Stack<Integer> idxStack = new Stack<Integer>();
        int max = 0, idx = 0;
        final int L = heights.length;
        
        while(idx < L){
            // once a lower height has been found, to "check out" to the leftmost taller height
            // 1. to calculate the area for each left taller height
            // 2. to get the max area/value among all along the way
            while(!idxStack.isEmpty() && heights[idx] < heights[idxStack.peek()]){
                max = Math.max(max, heights[idxStack.pop()] * (idx - (idxStack.isEmpty() ? 0 : idxStack.peek() + 1)));
            }
            
            idxStack.push(idx++);
        }
        
        // if there is any element/height left,
        // their heights all are "non-decreasing"
        while(!idxStack.isEmpty()){
            max = Math.max(max, heights[idxStack.pop()] * (L - (idxStack.isEmpty() ? 0 : idxStack.peek() + 1)));
        }
        
        return max;
    }
}