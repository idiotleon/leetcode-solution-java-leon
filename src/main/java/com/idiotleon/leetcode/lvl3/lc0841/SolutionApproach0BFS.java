/**
 * https://leetcode.com/problems/keys-and-rooms/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/keys-and-rooms/discuss/200749/Java-DFS-BFS-solution-with-explanation
 */
package com.idiotleon.leetcode.lvl3.lc0841;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0BFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // sanity check
        if (rooms == null || rooms.isEmpty())
            return true;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int cur = queue.poll();
                for (int next : rooms.get(cur)) {
                    if (seen.add(next)) {
                        queue.offer(next);
                    }
                }
            }
        }

        return seen.size() == rooms.size();
    }
}