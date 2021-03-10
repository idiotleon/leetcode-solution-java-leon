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
package com.an7one.leetcode.lvl3.lc0841;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // sanity check
        if (rooms == null || rooms.isEmpty())
            return true;

        Set<Integer> seen = new HashSet<>();
        dfs(0, seen, rooms);
        return seen.size() == rooms.size();
    }

    private void dfs(int room, Set<Integer> seen, List<List<Integer>> graph) {
        if (seen.contains(room))
            return;

        seen.add(room);
        for (int key : graph.get(room)) {
            dfs(key, seen, graph);
        }
    }
}