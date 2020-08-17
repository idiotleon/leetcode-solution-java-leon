/**
 * https://leetcode.com/problems/asteroid-collision/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl4.lc0735;

import java.util.Stack;

public class SolutionApproach0Stack1 {
    public int[] asteroidCollision(int[] asteroids){ // [5, 10, -5]
        // sanity check
        if(asteroids == null || asteroids.length == 0) return new int[0];

        final int N = asteroids.length;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < N; i++){ // 0, 1, 2
            int asteroid = asteroids[i]; // 5, 10, -5
            if(asteroid > 0 || stack.isEmpty() || stack.peek() < 0) // true, true, false
                stack.add(asteroid); // 5, 10, N.A.
            else if(stack.peek() <= -asteroid){ // false, false, false
                if(stack.pop() < -asteroid) // false, false, false
                    i--; // N.A., N.A, N.A.
            }
        }
        
        /*
        int[] ans = new int[stack.size()];
        int idx = stack.size() - 1;
        while(!stack.isEmpty()){
            ans[idx--] = stack.pop();
        }

        return ans;
        */
        return stack.stream().mapToInt(i -> i).toArray(); // [5, 10]
    }
}