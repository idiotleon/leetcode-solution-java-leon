/**
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 * 
 * a LinkedList is prefered than an ArrayDeque, 
 *  because `null` might be put int
 */
package com.zea7ot.lc.lvl3.lc0101;

import java.util.LinkedList;
import java.util.Queue;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null)
                continue;
            else if (n1 == null || n2 == null || n1.val != n2.val)
                return false;

            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }

        return true;
    }
}