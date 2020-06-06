/**
 * https://leetcode.com/problems/validate-stack-sequences/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl3.lc0946;

import java.util.Stack;

public class SolutionApproachStack2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int idxPushed = 0, idxPopped = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        while(idxPushed < pushed.length 
              || (!stack.isEmpty() && stack.peek() == popped[idxPopped])){
            
            if(stack.isEmpty() || stack.peek() != popped[idxPopped]){
                stack.push(pushed[idxPushed++]);
            }else{
                stack.pop();
                idxPopped++;
            }
        }
        
        if(idxPopped == popped.length) return true;
        return false;
    }
}