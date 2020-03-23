/**
 * https://leetcode.com/problems/min-stack/
 * 
 * Time Complexity : O(1) for all operations.
 * Space Complexity : O(n).
 * 
 */
package main.java.lcidiot.lc0155;

import java.util.Stack;

class MinStack {
    
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<int[]> minStack = new Stack<int[]>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        
        if(minStack.isEmpty() || x < minStack.peek()[0])
            minStack.push(new int[]{x, 1});
        else if(x == minStack.peek()[0])
            minStack.peek()[1]++;
        
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek()[0]))
            minStack.peek()[1]--;
        
        if(minStack.peek()[1] == 0)
            minStack.pop();
        
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
    }
}