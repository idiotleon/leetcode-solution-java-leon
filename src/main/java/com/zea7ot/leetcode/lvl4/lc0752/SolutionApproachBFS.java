/**
 * https://leetcode.com/problems/open-the-lock/
 */
package com.zea7ot.leetcode.lvl4.lc0752;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;

public class SolutionApproachBFS {
    public int openLock(String[] deadends, String target) {
        // sanity check
        if(target.equals("0000")) return -1;
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        Set<String> deadendSet = new HashSet<String>();
        for(String deadend : deadends){
            deadendSet.add(deadend);
        }
        
        int count = 0;
        String lock = "0000";
        if(!deadendSet.contains(lock)){
            visited.add(lock);
            queue.add(lock);
        }
        
        // BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                lock = queue.poll();
                if(deadendSet.contains(lock)) continue;
                if(lock.equals(target)) return count;
                
                // to change all four digits
                for(int j = 0; j < 4; j++){
                    // to rotate the lock by one, left and right
                    for(int k = -1; k <= 1; k += 2){
                        String next = lock;
                        char[] chs = next.toCharArray();
                        chs[j] = (char)((int)'0' + ((chs[j] - '0') + k + 10) % 10);
                        next = String.valueOf(chs);
                        
                        if(!deadendSet.contains(next) 
                           && !visited.contains(next)){
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
            
            count++;
        }
        
        return -1;
    }
}