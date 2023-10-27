package com.idiotleon.leetcode.lvl3.lc0735;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/asteroid-collision/">LC0735</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack {
    public int[] asteroidCollision(int[] asteroids) {
        // sanity check
        // final int N = asteroids.length;

        final Deque<Integer> stack = new ArrayDeque<>();

        for (final int asteroid : asteroids) {
            if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                }
            }
        }

        final int SIZE = stack.size();
        int idx = SIZE - 1;
        final int[] ans = new int[SIZE];
        while (!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }
        return ans;
    }
}
