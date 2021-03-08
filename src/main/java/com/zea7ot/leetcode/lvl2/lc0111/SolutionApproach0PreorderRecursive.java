/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36188/Very-easy-with-recursion-1ms-Java-solution/34395
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0111;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int[] minDepth = { Integer.MAX_VALUE };
        preorder(root, 1, minDepth);
        return minDepth[0];
    }

    private void preorder(TreeNode node, int curDepth, int[] minDepth) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            minDepth[0] = Math.min(minDepth[0], curDepth);
        }

        ++curDepth;
        preorder(node.left, curDepth, minDepth);
        preorder(node.right, curDepth, minDepth);
    }
}