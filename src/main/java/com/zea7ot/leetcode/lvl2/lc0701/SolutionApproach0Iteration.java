/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/150757/java-iterative-100/486467
 */
package com.zea7ot.leetcode.lvl2.lc0701;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // sanity check
        if (root == null)
            return new TreeNode(val);

        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            prev = cur;
            if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        if (prev.val < val) {
            prev.right = new TreeNode(val);
        } else {
            prev.left = new TreeNode(val);
        }

        return root;
    }
}