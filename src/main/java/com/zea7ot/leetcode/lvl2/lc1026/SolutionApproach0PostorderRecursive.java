/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a bottom-up approach
 */
package com.zea7ot.leetcode.lvl2.lc1026;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int maxAncestorDiff(TreeNode root) {
        return postorder(root, root.val, root.val);
    }

    private int postorder(TreeNode node, int max, int min) {
        if (node == null)
            return 0;

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        int left = postorder(node.left, max, min);
        int right = postorder(node.right, max, min);
        return Math.max(max - min, Math.max(left, right));
    }
}