/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc0094;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSRecursively {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        inorderTraverse(root, ans);
        return ans;
    }

    private void inorderTraverse(TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        inorderTraverse(node.left, res);
        res.add(node.val);
        inorderTraverse(node.right, res);
    }
}