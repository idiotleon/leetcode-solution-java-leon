/**
 * https://leetcode.com/problems/race-car/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/race-car/discuss/142360/Logical-Thinking-with-Clean-Java-Code
 */
package com.an7one.leetcode.lvl5.lc0818;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS {
    public int racecar(int target) {
        Set<String> visited = new HashSet<String>();
        Queue<CarState> queue = new LinkedList<CarState>();
        queue.add(new CarState(1, 0));
        int distance = 0;
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            
            for(int i = 0; i < SIZE; i++){
                CarState top = queue.poll();
                if(top.position == target) return distance;
                
                int nextPosition = top.position + top.speed;
                int nextSpeed = top.speed * 2;
                String hash1 = nextSpeed + "," + nextPosition;
                if(!visited.contains(hash1) && Math.abs(target - nextPosition) < target){
                    visited.add(hash1);
                    queue.offer(new CarState(nextSpeed, nextPosition));
                }
                
                nextPosition = top.position;
                nextSpeed = top.speed > 0 ? -1 : 1;
                String hash2 = nextSpeed + "," + nextPosition;
                if(!visited.contains(hash2) && Math.abs(target - nextPosition) < target){
                    visited.add(hash2);
                    queue.offer(new CarState(nextSpeed, nextPosition));
                }
            }
            distance++;
        }
        
        return -1;
    }
    
    private class CarState{
        protected int speed;
        protected int position;
        
        protected CarState(int speed, int position){
            this.speed = speed;
            this.position = position;
        }
    }
}