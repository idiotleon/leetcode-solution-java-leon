/**
 * https://leetcode.com/problems/online-stock-span/
 * 
 * Time Complexity:     O(N) ~ O(N ^ 2)
 * Space Complexity:    O(1) ~ O(N)
 * 
 * to maintain a strictly "decreasing" order:
 *  1. the contents are an 2-element array of price and count
 *  2. the prices are strictly decreasing
 */
package com.idiotleon.leetcode.ood.lvl3.lc0901;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoStack {
    private Deque<int[]> stack;

    public SolutionApproach0MonoStack() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[] { price, span });

        return span;
    }
}