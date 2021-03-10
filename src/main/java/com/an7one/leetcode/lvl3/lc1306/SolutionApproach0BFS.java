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

public class SolutionApproach0BFS {
    public boolean canReach(int[] nums, int start) {
        final int N = nums.length;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        final Set<Integer> SEEN = new HashSet<>();
        SEEN.add(start);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int curIdx = queue.poll();
                if (nums[curIdx] == 0)
                    return true;

                int loNextIdx = curIdx - nums[curIdx];
                if (loNextIdx >= 0 && loNextIdx < N && SEEN.add(loNextIdx)) {
                    queue.offer(loNextIdx);
                }

                int hiNextIdx = curIdx + nums[curIdx];
                if (hiNextIdx >= 0 && hiNextIdx < N && SEEN.add(hiNextIdx)) {
                    queue.offer(hiNextIdx);
                }
            }
        }

        return false;
    }
}
