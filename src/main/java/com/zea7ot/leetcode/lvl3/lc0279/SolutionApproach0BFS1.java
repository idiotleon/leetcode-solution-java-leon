/**
 * https://leetcode.com/problems/perfect-squares/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl3.lc0279;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS1 {
    public int numSquares(int n) {
        // sanity check
        if (n == 0 || n == 1)
            return n;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);

        Set<Integer> visited = new HashSet<Integer>();
        visited.add(0);

        int steps = 1;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                int cur = queue.poll();
                for (int j = 1; cur + j * j <= n; j++) {
                    int temp = cur + j * j;
                    if (temp == n)
                        return steps;
                    if (!visited.add(temp))
                        continue;
                    queue.offer(temp);
                }
            }
            ++steps;
        }

        return -1;
    }
}