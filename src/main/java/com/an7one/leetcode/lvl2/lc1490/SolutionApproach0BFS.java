
package com.an7one.leetcode.lvl2.lc1490;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/clone-n-ary-tree/">LC1490</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public Node cloneTree(Node root) {
        // sanity check
        if (root == null)
            return null;

        final Map<Node, Node> map = new HashMap<>();
        map.put(root, new Node(root.val));

        final Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            final int sizeQ = queue.size();

            for (int i = 0; i < sizeQ; ++i) {
                final Node cur = queue.removeFirst();

                for (final Node next : cur.children) {
                    if (!map.containsKey(next)) {
                        map.put(next, new Node(next.val));
                        queue.addLast(next);
                    }

                    map.get(cur).children.add(map.get(next));
                }
            }
        }

        return map.get(root);
    }
}
