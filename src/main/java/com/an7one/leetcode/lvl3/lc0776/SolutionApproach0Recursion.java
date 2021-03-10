/**
 * https://leetcode.com/problems/split-bst/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/split-bst/discuss/114861/Java-Recursion-in-O(logn)/115833
 *  https://leetcode.com/problems/split-bst/discuss/114861/Java-Recursion-in-O(logn)
 */
package com.an7one.leetcode.lvl3.lc0776;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0Recursion {
    public TreeNode[] splitBST(TreeNode root, int target) {
        // sanity check
        if (root == null)
            return new TreeNode[] { null, null };

        TreeNode[] splitted;
        if (root.val <= target) {
            splitted = splitBST(root.right, target);
            root.right = splitted[0];
            splitted[0] = root;
        } else {
            splitted = splitBST(root.left, target);
            root.left = splitted[1];
            splitted[1] = root;
        }

        return splitted;
    }
}