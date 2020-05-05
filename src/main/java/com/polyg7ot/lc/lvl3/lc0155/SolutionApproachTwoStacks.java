/**
 * https://leetcode.com/problems/min-stack/
 * 
 * Time Complexity : O(1) for all operations.
 * Space Complexity : O(n)
 * 
 */
package com.polyg7ot.lc.lvl3.lc0155;

import java.util.Stack;

public class SolutionApproachTwoStacks {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    /** initialize your data structure here. */
    public SolutionApproachTwoStacks() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}