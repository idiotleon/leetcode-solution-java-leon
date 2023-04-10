/**
 * https://leetcode.com/problems/asteroid-collision/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.idiotleon.leetcode.lvl4.lc0735;

import java.util.LinkedList;

public class SolutionApproach0Stack2 {
    public int[] asteroidCollision(int[] asteroids) {
        // sanity check
        if(asteroids == null || asteroids.length == 0) return new int[0];

        final int N = asteroids.length;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < N; i++){
            int asteroid = asteroids[i];
            if(asteroid > 0 || stack.isEmpty() || stack.getLast() < 0) stack.add(asteroid);
            else if(stack.getLast() <= -asteroid){
                if(stack.removeLast() < -asteroid) i--;
            }
        }
        
        return stack.stream().mapToInt(i -> i).toArray();
    }
}