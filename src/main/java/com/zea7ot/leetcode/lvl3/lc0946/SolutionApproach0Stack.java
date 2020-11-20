/**
 * https://leetcode.com/problems/validate-stack-sequences/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/validate-stack-sequences/discuss/197685/C%2B%2BJavaPython-Simulation-O(1)-Space
 */
package com.zea7ot.leetcode.lvl3.lc0946;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        int idx = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }

        return stack.isEmpty();
    }
}