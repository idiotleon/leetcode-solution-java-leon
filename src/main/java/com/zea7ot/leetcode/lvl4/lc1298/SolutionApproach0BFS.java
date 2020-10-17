/**
 * https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/
 * 
 * Time Complexity:     O(V + E) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/discuss/457658/Easy-way-using-Queue-JAVA
 */
package com.zea7ot.leetcode.lvl4.lc1298;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    private static final int STATUS_OPEN = 1;
    private static final int STATUS_CLOSED = 0;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        final int N = status.length;
        boolean[] opened = new boolean[N];
        boolean[] toBeOpened = new boolean[N];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int box : initialBoxes) {
            queue.offer(box);
            toBeOpened[box] = true;
        }

        int most = 0;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                int cur = queue.poll();

                if (status[cur] == STATUS_CLOSED || opened[cur])
                    continue;

                most += candies[cur];
                opened[cur] = true;

                // with keys, one can open corresponding boxes
                for (int box : keys[cur]) {
                    status[box] = STATUS_OPEN;
                    if (toBeOpened[box]) {
                        queue.offer(box);
                    }
                }

                // for contained boxes
                for (int box : containedBoxes[cur]) {
                    toBeOpened[box] = true;
                    queue.offer(box);
                }
            }
        }

        return most;
    }
}
