/**
 * https://leetcode.com/problems/asteroid-collision/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl4.lc0735;

import java.util.Arrays;

public class SolutionApproachStack {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        
        int top = -1;
        for(int cur : asteroids){
            if(cur > 0) stack[++top] = cur;
            else{
                // to pop out all smaller(absolute values) asteroids
                while(top > -1 && stack[top] > 0 && stack[top] < -cur) top--;
                
                // to save it were all left elements going-left asteroids
                if(top == -1 || stack[top] < 0) stack[++top] = cur;
                // to demolish both, if they are equal(absolute value)
                else if(stack[top] == -cur) top--;
            }
        }
        
        return Arrays.copyOf(stack, top + 1);
    }   
}