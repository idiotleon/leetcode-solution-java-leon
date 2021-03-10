/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.an7one.leetcode.lvl3.lc0117;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS1 {
    public Node connect(Node root) {
        // sanity check
        if (root == null)
            return null;

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                Node cur = queue.poll();

                if (i < SIZE - 1) {
                    cur.next = queue.peekFirst();
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return root;
    }
}
