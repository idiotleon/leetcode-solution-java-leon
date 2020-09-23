/**
 * @author: Leon
 * https://leetcode.com/problems/find-all-the-lonely-nodes/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc1469;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        preorder(root, ans);

        return ans;
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left == null && right != null) {
            res.add(right.val);
        } else if (left != null && right == null) {
            res.add(left.val);
        }

        preorder(node.left, res);
        preorder(node.right, res);
    }
}
