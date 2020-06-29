/**
 * https://leetcode.com/problems/asteroid-collision/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl4.lc0735;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionApproach0Stack3 {
    public int[] asteroidCollision(int[] asteroids) {
        // sanity check
        if(asteroids == null || asteroids.length == 0) return new int[0];

        final int N = asteroids.length;
        List<Integer> ans = new ArrayList<Integer>();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        for(int i = 0; i < N; i++){
            int cur = asteroids[i];
            if(cur < 0){
                while(!stack.isEmpty() && stack.peekLast() < Math.abs(cur)) stack.removeLast();
                    
                if(stack.isEmpty()) ans.add(cur);
                else if(stack.peekLast() == Math.abs(cur)) stack.removeLast();
            }else stack.add(cur);
        }
        
        while(!stack.isEmpty()) ans.add(stack.removeFirst());
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}