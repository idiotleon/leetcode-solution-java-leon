/**
 * https://leetcode.com/problems/asteroid-collision/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl4.lc0735;

import java.util.LinkedList;

public class SolutionApproachStack1 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        for(int i = 0; i < asteroids.length; i++){
            int cur = asteroids[i];
            if(cur > 0 || stack.isEmpty() || stack.getLast() < 0){
                stack.add(cur);
            }else if(stack.getLast() <= -cur){
                if(stack.removeLast() < -cur){
                    i--;
                }
            }
        }
        
        return stack.stream().mapToInt(i -> i).toArray();
    }
}