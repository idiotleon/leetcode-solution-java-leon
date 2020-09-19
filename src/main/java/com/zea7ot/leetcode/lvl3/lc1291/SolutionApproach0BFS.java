/**
 * https://leetcode.com/problems/sequential-digits/
 * 
 * Time Complexity:     O(lg(`high`)) ~ O(1)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sequential-digits/discuss/453429/Java-Concise-and-Short-BFS
 */
package com.zea7ot.leetcode.lvl3.lc1291;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0BFS {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < 10; ++i)
            queue.offer(i);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                int cur = queue.poll();
                if (cur >= low && cur <= high)
                    ans.add(cur);

                int digit = cur % 10;
                if (digit < 9 && cur * 10 + digit + 1 <= high)
                    queue.offer(cur * 10 + digit + 1);
            }
        }

        return ans;
    }
}
