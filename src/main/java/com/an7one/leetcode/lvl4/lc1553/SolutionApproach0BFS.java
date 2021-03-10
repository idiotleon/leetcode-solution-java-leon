/**
 * https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
 * 
 * Time Complexity:     O(lg(n))
 * Space Compleixty:    O(lg(n))
 * 
 * References:
 *  https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/discuss/794072/Java-Easy-Understanding-BFS
 */
package com.an7one.leetcode.lvl4.lc1553;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    public int minDays(int n) {
        // sanity check
        if (n <= 0)
            return 0;

        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(n);

        Set<Integer> seen = new HashSet<Integer>();

        int days = 1;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                int oranges = queue.poll();
                if (oranges == 1)
                    return days;

                if (!seen.add(oranges))
                    continue;

                if (oranges % 3 == 0)
                    queue.add(oranges / 3);

                if (oranges % 2 == 0)
                    queue.add(oranges / 2);

                queue.add(oranges - 1);
            }

            ++days;
        }

        return -1;
    }
}