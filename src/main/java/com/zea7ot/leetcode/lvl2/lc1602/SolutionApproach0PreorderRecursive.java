/**
 * https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/discuss/872996/Java-O(n)-Preorder
 */
package com.zea7ot.leetcode.lvl2.lc1602;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    private TreeNode res = null;
    private int targetDepth = -1;

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == u)
            return null;

        preorder(root, u, 0);
        return res;
    }

    private void preorder(TreeNode node, TreeNode target, int curDepth) {
        if (node == null)
            return;
        if (node == target) {
            targetDepth = curDepth;
            return;
        }

        // not necessary
        // if (targetDepth > 0) {
        if (curDepth == targetDepth && res == null) {
            res = node;
            return;
        }
        // }

        preorder(node.left, target, curDepth + 1);
        preorder(node.right, target, curDepth + 1);
    }
}
