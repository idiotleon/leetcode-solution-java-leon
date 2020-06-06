/**
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * to maintain a "non-increasing" stack
 * 1. the elements of the stack are indexes, instead of values
 * 2. the values in the given array, accessed by those indexes, are in non-increasing order
 */
package com.zea7ot.lc.lvl3.lc0739;

import java.util.Stack;

public class SolutionApproachStack {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[0];
        final int L = T.length;
        
        int[] ans = new int[L]; 
        Stack<Integer> idxStack = new Stack<Integer>();
        
        int idx = 0;
        while(idx < L){
            while(!idxStack.isEmpty() && T[idxStack.peek()] < T[idx]){
                int prevIdx= idxStack.pop();
                ans[prevIdx] = idx - prevIdx;
            }
            
            idxStack.push(idx++);
        }
        
        return ans;
    }
}