/**
 * https://leetcode.com/problems/stepping-numbers/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/stepping-numbers/discuss/397600/Simple-BFS
 */
package com.zea7ot.leetcode.lvl3.lc1215;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0BFS {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (low > high)
            return ans;

        Deque<Long> queue = new ArrayDeque<>();
        for (int i = 1; i < 10; ++i) {
            queue.offer(1L * i);
        }

        if (low == 0)
            ans.add(0);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                long cur = queue.poll();

                if (cur < high) {
                    long last = cur % 10;
                    if (last > 0) {
                        queue.offer(cur * 10 + last - 1);
                    }
                    {
                        if (last < 9) {
                            queue.offer(cur * 10 + last + 1);
                        }
                    }

                    if (cur >= low && cur <= high) {
                        ans.add((int) cur);
                    }
                }
            }

        }
        return ans;
    }
}
