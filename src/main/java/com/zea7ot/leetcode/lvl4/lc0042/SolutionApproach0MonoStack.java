/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to maintain a "non-increasing" stack:
 * 1. to contain indexes, instead of heights/values
 * 2. to maintain a non-increasing order of heights in the stack
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
package com.zea7ot.leetcode.lvl4.lc0042;

import java.util.Stack;

public class SolutionApproach0MonoStack {
    public int trap(int[] height) { // [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        // sanity check
        if(height == null || height.length < 2) return 0;

        final int N = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int water = 0, idx = 0;

        while(idx < N){
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