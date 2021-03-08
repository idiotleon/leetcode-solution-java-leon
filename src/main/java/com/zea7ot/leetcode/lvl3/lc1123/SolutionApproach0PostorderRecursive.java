/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * Reference:
 *  https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334577/JavaC%2B%2BPython-Two-Recursive-Solution
 */
package com.zea7ot.leetcode.lvl3.lc1123;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    private TreeNode lca = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int[] deepest = { 0 };
        postorder(root, 0, deepest);
        return lca;
    }

    private int postorder(TreeNode node, int depth, int[] deepest) {
        deepest[0] = Math.max(depth, deepest[0]);
        if (node == null)
            return depth;

        int left = postorder(node.left, depth + 1, deepest);
        int right = postorder(node.right, depth + 1, deepest);

        if (left == deepest[0] && right == deepest[0]) {
            lca = node;
        }

        return Math.max(left, right);
    }
}