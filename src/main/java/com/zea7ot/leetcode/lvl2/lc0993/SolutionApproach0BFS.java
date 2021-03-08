/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl2.lc0993;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public boolean isCousins(TreeNode root, int x, int y) {
        // santy check
        if (root == null)
            return false;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xExists = false;
            boolean yExists = false;

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.removeFirst();
                if (cur.val == x)
                    xExists = true;
                if (cur.val == y)
                    yExists = true;

                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y)
                        return false;
                    if (cur.left.val == y && cur.right.val == x)
                        return false;
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            if (xExists && yExists)
                return true;
            if (xExists || yExists)
                return false;
        }

        return false;
    }
}