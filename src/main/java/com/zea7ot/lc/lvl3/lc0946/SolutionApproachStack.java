/**
 * https://leetcode.com/problems/validate-stack-sequences/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl3.lc0946;

import java.util.Stack;

public class SolutionApproachStack {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int idx = 0;
        for(int num : pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[idx]){
                stack.pop();
                idx++;
            }
        }
        
        return stack.isEmpty();
    }
}