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

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leaves1 = new StringBuilder();
        postorder(root1, leaves1);
        StringBuilder leaves2 = new StringBuilder();
        postorder(root2, leaves2);

        return leaves1.toString().equals(leaves2.toString());
    }

    private void postorder(TreeNode node, StringBuilder builder) {
        if (node == null)
            return;

        postorder(node.left, builder);
        postorder(node.right, builder);

        if (isLeaf(node))
            builder.append(String.valueOf(node.val) + "-");
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }
}