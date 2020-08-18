/**
 * https://leetcode.com/problems/keys-and-rooms/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/keys-and-rooms/discuss/200749/Java-DFS-BFS-solution-with-explanation
 */
package com.zea7ot.leetcode.lvl3.lc0841;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // sanity check
        if(rooms == null || rooms.isEmpty()) return true;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        Set<Integer> seen = new HashSet<Integer>();
        seen.add(0);
        
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int key : rooms.get(top)){
                if(!seen.contains(key)){
                    queue.offer(key);
                    seen.add(key);
                }
            }
        }
        
        return seen.size() == rooms.size();
    }
}