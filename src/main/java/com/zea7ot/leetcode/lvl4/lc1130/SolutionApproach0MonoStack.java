/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
 */
package com.zea7ot.leetcode.lvl4.lc1130;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoStack {
    public int mctFromLeafValues(int[] nums) {
        int minCost = 0;

        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(Integer.MAX_VALUE);

        for (int num : nums) {
            while (stack.peek() <= num) {
                int mid = stack.pop();
                minCost += mid * Math.min(stack.peek(), num);
            }

            stack.push(num);
        }

        while (stack.size() > 2) {
            minCost += stack.pop() * stack.peek();
        }

        return minCost;
    }
}