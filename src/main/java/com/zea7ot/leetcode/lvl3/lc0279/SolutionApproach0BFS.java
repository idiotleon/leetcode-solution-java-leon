/**
 * https://leetcode.com/problems/perfect-squares/
 * 
 * Time Complexity:     ?O(lg(n))
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)/311680
 */
package com.zea7ot.leetcode.lvl3.lc0279;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    public int numSquares(int n) {
        if (n <= 0)
            return 0;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        Set<Integer> seen = new HashSet<>();
        seen.add(n);

        int steps = 1;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                int remain = queue.poll();

                for (int j = 1; j * j <= remain; ++j) {
                    int val = remain - j * j;
                    if (val == 0)
                        return steps;
                    if (!seen.add(val))
                        continue;
                    queue.add(val);
                }
            }

            ++steps;
        }

        return -1;
    }
}