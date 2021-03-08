/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/150757/java-iterative-100/253274
 */
package com.zea7ot.leetcode.lvl2.lc0701;

import com.zea7ot.util.data_structure.tree.TreeNode;

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