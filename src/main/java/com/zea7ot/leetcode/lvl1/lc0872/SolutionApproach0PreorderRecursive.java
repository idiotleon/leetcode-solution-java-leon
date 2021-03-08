/**
 * https://leetcode.com/problems/leaf-similar-trees/
 * 
 * Time Complexity:     O(N1 + N2)
 * Space Complexity:    O(N1 + N2)
 * 
 * References:
 *  https://leetcode.com/problems/leaf-similar-trees/discuss/152358/Simple-6-lines-Java-StringBuilder-%2B-traverse-with-explanation
 */
package com.zea7ot.leetcode.lvl1.lc0872;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leaves1 = new StringBuilder();
        preorder(root1, leaves1);
        StringBuilder leaves2 = new StringBuilder();
        preorder(root2, leaves2);

        return leaves1.toString().equals(leaves2.toString());
    }

    private void preorder(TreeNode node, StringBuilder builder) {
        if (node == null)
            return;

        if (isLeaf(node))
            builder.append(String.valueOf(node.val) + "-");

        preorder(node.left, builder);
        preorder(node.right, builder);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }
}