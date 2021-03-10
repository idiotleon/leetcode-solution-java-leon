/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.an7one.leetcode.lvl3.lc0116;

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
                Node node = queue.poll();
                if (i < SIZE - 1)
                    node.next = queue.peek();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return root;
    }
}