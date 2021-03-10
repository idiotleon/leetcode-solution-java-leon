/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.an7one.leetcode.lvl4.lc0117;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    public Node connect(Node root) {
        // sanity check
        if (root == null)
            return root;

        Deque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; i++) {
                Node cur = queue.poll();
                if (i < SIZE - 1)
                    cur.next = queue.peek();

                if (cur.left != null)
                    queue.add(cur.left);

                if (cur.right != null)
                    queue.add(cur.right);
            }
        }

        return root;
    }
}