package com.an7one.leetcode.lvl2.lc0701;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/insert-into-a-binary-search-tree/">LC0701</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/150757/java-iterative-100/253274">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Recursion {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // sanity check
        if (root == null)
            return new TreeNode(val);

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}