/**
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to maintain a "non-increasing" stack
 * 1. the elements of the stack are indexes, instead of values
 * 2. the values in the given array, accessed by those indexes, are in non-increasing order
 */
package com.zea7ot.lc.lvl3.lc0739;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionApproach0MonoStack {
    public int[] dailyTemperatures(int[] T) {
        // sanity check
        if(T == null || T.length == 0) return new int[0];
        final int N = T.length;
        
        int[] ans = new int[N]; 
        Deque<Integer> idxStack = new LinkedList<Integer>();
        
        int idx = 0;
        while(idx < N){
            while(!idxStack.isEmpty() && T[idxStack.peek()] < T[idx]){
                int prevIdx= idxStack.pop();
                ans[prevIdx] = idx - prevIdx;
            }
            
            idxStack.push(idx++);
        }
        
        return ans;
    }
}