/**
 * https://leetcode.com/problems/min-stack/
 * 
 * Time Complexity :    O(1) for all operations.
 * Space Complexity :   O(N)
 */
package com.an7one.leetcode.ood.lvl3.lc0155;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack1 {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public SolutionApproach0Stack1() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek()))
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