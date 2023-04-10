/**
 * https://leetcode.com/problems/asteroid-collision/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.idiotleon.leetcode.lvl4.lc0735;

import java.util.Arrays;

public class SolutionApproach0Stack {
    public int[] asteroidCollision(int[] asteroids) {
        // sanity check
        if(asteroids == null || asteroids.length == 0) return new int[0];
        final int N = asteroids.length;
        int[] stack = new int[N];
        
        int top = -1;
        for(int asteriod : asteroids){
            if(asteriod > 0) stack[++top] = asteriod;
            else{
                // to pop out all smaller(absolute values) asteroids
                while(top > -1 && stack[top] > 0 && stack[top] < -asteriod) top--;
                
                // to save it were all left elements going-left asteroids
                if(top == -1 || stack[top] < 0) stack[++top] = asteriod;
                // to demolish both, if they are equal(absolute value)
                else if(stack[top] == -asteriod) top--;
            }
        }
        
        return Arrays.copyOf(stack, top + 1);
    }   
}