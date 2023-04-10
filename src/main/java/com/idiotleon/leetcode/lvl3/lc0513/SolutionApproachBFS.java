package com.idiotleon.leetcode.lvl3.lc0513;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/find-bottom-left-tree-value/">LC0513</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproachBFS {
    public int findBottomLeftValue(TreeNode root) {
        // it is assumed that root is NOT null
        // no need to perform sanity check
        final Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int ans = root.val;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.removeFirst();
                if (i == 0) ans = cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }

        return ans;
    }
}