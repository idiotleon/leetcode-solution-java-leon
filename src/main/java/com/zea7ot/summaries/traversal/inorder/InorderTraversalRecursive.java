/**
 * pseudo code:
 *  inorder(root):
 *      inorder(root.left)
 *      func(root.val)
 *      inorder(root.right)
 * 
 * Time Complexity:
 *  T(N) = 2 * T(N / 2) + O(1) = O(N), for a perfect binary tree
 *  T(N) = T(N - 1) + T(1) + O(1) = O(N), in the worst case
 * 
 * Space Complexity:    O(H)
 *  O(lg(N))    for a perfect binary tree
 *  O(N)        in the worst case
 * 
 * References:
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */
package com.zea7ot.summaries.traversal.inorder;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class InorderTraversalRecursive {
    public List<Integer> inorderTraverse(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
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