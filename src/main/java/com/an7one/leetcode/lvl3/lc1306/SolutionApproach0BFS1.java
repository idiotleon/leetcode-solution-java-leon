/**
 * @author: Leon
 * https://leetcode.com/problems/jump-game-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl3.lc1306;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS1 {
    public boolean canReach(int[] nums, int start) {
        final int N = nums.length;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        final Set<Integer> SEEN = new HashSet<>();

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int idx = queue.poll();
                if (idx < 0 || idx >= N)
                    continue;
                if (!SEEN.add(idx))
                    continue;
                if (nums[idx] == 0)
                    return true;

                queue.add(idx + nums[idx]);
                queue.add(idx - nums[idx]);
            }
        }

        return false;
    }
}
