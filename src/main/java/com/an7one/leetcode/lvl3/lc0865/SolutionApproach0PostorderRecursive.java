package com.an7one.leetcode.lvl3.lc0865;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/discuss/146808/C%2B%2BJavaPython-One-Pass
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0PostorderRecursive {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;

        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right)
            return root;

        if (left > right)
            return subtreeWithAllDeepest(root.left);

        return subtreeWithAllDeepest(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}