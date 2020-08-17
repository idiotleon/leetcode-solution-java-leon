/**
 * https://leetcode.com/problems/keys-and-rooms/
 * 
 * Time Complexity:     O(L)
 *  L, length of the rooms(List<List<Integer>>)
 * 
 * Space Complexity:    O(L)
 *  L, length of the rooms(List<List<Integer>>)
 * 
 * References:
 *  https://leetcode.com/problems/keys-and-rooms/discuss/133944/Java-8-lines
 */
package com.zea7ot.leetcode.lvl3.lc0841;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // sanity check
        if(rooms == null || rooms.isEmpty()) return true;

        Set<Integer> visited = new HashSet<Integer>();
        dfs(0, rooms, visited);
        return visited.size() == rooms.size();
    }
    
    private void dfs(int room, List<List<Integer>> rooms, Set<Integer> visited){
        if(visited.contains(room)) return;
        visited.add(room);
        for(int key : rooms.get(room)){
            dfs(key, rooms, visited);
        }
    }
}