/**
 * https://leetcode.com/problems/online-stock-span/
 * 
 * Time Complexity: O(N) ~ O(N ^ 2)
 * Space Complexity: O(1) ~ O(N)
 * 
 * to maintain a strictly "decreasing" order:
 * 1. the contents are an 2-element array of price and count
 * 2. the prices are strictly decreasing
 */
package com.polyg7ot.lc.lvl3.lc0901;

import java.util.LinkedList;

public class SolutionApproachStack {
    private LinkedList<int[]> stack;

    public SolutionApproachStack() {
        this.stack = new LinkedList<int[]>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peekLast()[0] <= price){
            span += stack.removeLast()[1];
        }
        
        stack.add(new int[]{price, span});
        
        return span;
    }
}