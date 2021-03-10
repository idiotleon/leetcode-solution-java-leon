/**
 * @author: Leon
 * https://leetcode.com/problems/asteroid-collision/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl3.lc0735;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    public int[] asteroidCollision(int[] asteroids) {
        // sanity check
        // final int N = asteroids.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroid);
                else if (stack.peek() == -asteroid)
                    stack.pop();
            }
        }

        final int SIZE = stack.size();
        int idx = SIZE - 1;
        int[] ans = new int[SIZE];
        while (!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }
        return ans;
    }
}
