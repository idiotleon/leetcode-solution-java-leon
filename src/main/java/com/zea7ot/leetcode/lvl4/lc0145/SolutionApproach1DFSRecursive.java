/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl4.lc0145;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1DFSRecursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        postorder(root, ans);
        return ans;
    }

    private void postorder(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;

        postorder(node.left, ans);
        postorder(node.right, ans);
        ans.add(node.val);
    }
}