/**
 * https://leetcode.com/problems/keys-and-rooms/
 * 
 * Time Complexity:     O(L)
 * Space Compleixty:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/keys-and-rooms/discuss/133855/Straight-Forward
 */
package com.an7one.leetcode.lvl3.lc0841;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0SimulateRecursion {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // sanity check
        if (rooms == null || rooms.isEmpty())
            return true;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        Set<Integer> seen = new HashSet<Integer>();
        seen.add(0);

        while (!stack.isEmpty()) {
            int room = stack.pop();
            for (int key : rooms.get(room)) {
                if (!seen.contains(key)) {
                    seen.add(key);
                    stack.add(key);
                }
            }
        }

        return rooms.size() == seen.size();
    }
}