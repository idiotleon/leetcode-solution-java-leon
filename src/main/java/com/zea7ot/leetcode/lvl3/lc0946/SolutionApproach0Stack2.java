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

public class SolutionApproach0Stack2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int idxPushed = 0, idxPopped = 0;

        Deque<Integer> stack = new ArrayDeque<Integer>();

        while (idxPushed < pushed.length || (!stack.isEmpty() && stack.peek() == popped[idxPopped])) {

            if (stack.isEmpty() || stack.peek() != popped[idxPopped]) {
                stack.push(pushed[idxPushed++]);
            } else {
                stack.pop();
                idxPopped++;
            }
        }

        if (idxPopped == popped.length)
            return true;
        return false;
    }
}