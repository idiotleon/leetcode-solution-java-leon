/**
 * https://leetcode.com/problems/max-stack/
 * 
 * Time Complexity:
 *  popMax: O(N)
 *  others: O(1)
 * 
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/articles/max-stack/
 */
package com.zea7ot.leetcode.lvl3.lc0716;

import java.util.Stack;

public class SolutionApproach0Stack {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    
    /** initialize your data structure here. */
    public SolutionApproach0Stack() {
        this.stack = new Stack<Integer>();
        this.maxStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<Integer>();
        while(top() != max) buffer.push(pop());
        pop();
        while(!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}