/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36188/Very-easy-with-recursion-1ms-Java-solution/34395
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0111;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive3 {
    public int minDepth(TreeNode root) {
        return postorder(root);
    }

    public int postorder(TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        int minDepth = Integer.MAX_VALUE;

        if (node.left != null) {
            minDepth = Math.min(postorder(node.left), minDepth);
        }

        if (node.right != null) {
            minDepth = Math.min(postorder(node.right), minDepth);
        }

        return minDepth + 1;
    }
}