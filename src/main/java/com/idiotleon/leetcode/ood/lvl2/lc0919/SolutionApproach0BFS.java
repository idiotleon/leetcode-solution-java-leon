/**
 * https://leetcode.com/problems/complete-binary-tree-inserter/
 * 
 * Time Complexities:
 *  initialization:     O(N)
 *  insert:             O(1)
 * 
 * Space Complexity:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/complete-binary-tree-inserter/discuss/178427/JavaPython-3-2-BFS-straightforward-codes-Initialization-and-insert-time-O(1)-respectively.
 */
package com.idiotleon.leetcode.ood.lvl2.lc0919;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    private TreeNode root;
    private Deque<TreeNode> queue;

    public SolutionApproach0BFS(TreeNode root) {
        this.root = root;
        this.queue = new ArrayDeque<>();
        queue.offer(root);

        while (queue.peek().right != null) {
            queue.offer(queue.peek().left);
            queue.offer(queue.poll().right);
        }
    }

    public int insert(int v) {
        TreeNode cur = queue.peek();
        if (cur.left == null) {
            cur.left = new TreeNode(v);
        } else {
            cur.right = new TreeNode(v);
            queue.offer(cur.left);
            queue.offer(cur.right);
            queue.poll();
        }

        return cur.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
