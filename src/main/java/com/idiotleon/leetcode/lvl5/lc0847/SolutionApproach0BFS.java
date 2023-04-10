/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 * 
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 * 
 * References:
 *  https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135809/Fast-BFS-Solution-(46ms)-Clear-Detailed-Explanation-Included/237938
 *  https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135809/Fast-BFS-Solution-(46ms)-Clear-Detailed-Explanation-Included
 */
package com.idiotleon.leetcode.lvl5.lc0847;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    public int shortestPathLength(int[][] graph) {
        final int N = graph.length;
        final int FULL_MASK = (1 << N) - 1;

        final Set<String> SEEN = new HashSet<>();

        Deque<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            Node node = new Node(i, 1 << i);
            queue.offer(node);
            SEEN.add(node.toHash());
        }

        int level = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                Node cur = queue.poll();
                int curId = cur.curId;
                int bitMask = cur.bitMask;

                if (bitMask == FULL_MASK)
                    return level;

                for (int nextId : graph[curId]) {
                    Node nextNode = new Node(nextId, bitMask | (1 << nextId));
                    if (!SEEN.add(nextNode.toHash()))
                        continue;
                    queue.offer(nextNode);
                }
            }

            ++level;
        }

        return level;
    }

    private class Node {
        private int curId;
        private int bitMask;

        private Node(int curId, int bitMask) {
            this.curId = curId;
            this.bitMask = bitMask;
        }

        private String toHash() {
            return "" + curId + "#" + bitMask;
        }
    }
}
