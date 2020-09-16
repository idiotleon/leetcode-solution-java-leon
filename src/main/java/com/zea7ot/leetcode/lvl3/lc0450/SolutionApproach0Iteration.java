/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/delete-node-in-a-bst/discuss/93298/Iterative-solution-in-Java-O(h)-time-and-O(1)-space/193018
 *  https://leetcode.com/problems/delete-node-in-a-bst/discuss/93298/Iterative-solution-in-Java-O(h)-time-and-O(1)-space
 */
package com.zea7ot.leetcode.lvl3.lc0450;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root, prev = null;
        while (cur != null && cur.val != key) {
            prev = cur;
            if (key < cur.val)
                cur = cur.left;
            else if (key > cur.val)
                cur = cur.right;
        }

        if (prev == null)
            return deleteRootNode(cur);

        if (prev.left == cur)
            prev.left = deleteRootNode(cur);
        else
            prev.right = deleteRootNode(cur);

        return root;
    }

    private TreeNode deleteRootNode(TreeNode node) {
        if (node == null)
            return null;

        if (node.left == null)
            return node.right;

        if (node.right == null)
            return node.left;

        TreeNode next = findMin(node.right);
        next.left = node.left;

        return node.right;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}