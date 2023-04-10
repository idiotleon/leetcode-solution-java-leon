/**
 * https://leetcode.com/problems/factor-combinations/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.idiotleon.leetcode.lvl3.lc0254;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0BFS {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (n <= 3)
            return ans;

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(n, 2));

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                Node cur = queue.poll();
                final int FACTOR = cur.FACTOR;
                if (FACTOR == 1) {
                    if (cur.PATH.size() > 1)
                        ans.add(new ArrayList<>(cur.PATH));
                    continue;
                }

                for (int j = cur.START; j <= FACTOR; ++j) {
                    if (FACTOR % j != 0)
                        continue;
                    Node next = new Node(FACTOR / j, j);
                    next.PATH.addAll(cur.PATH);
                    next.PATH.add(j);
                    queue.offer(next);
                }
            }
        }

        return ans;
    }

    private class Node {
        private final int FACTOR;
        private final int START;
        private final List<Integer> PATH;

        private Node(final int FACTOR, final int START) {
            this.FACTOR = FACTOR;
            this.START = START;
            this.PATH = new ArrayList<>();
        }
    }
}
