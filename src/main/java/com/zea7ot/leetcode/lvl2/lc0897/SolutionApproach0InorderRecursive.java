/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/increasing-order-search-tree/discuss/165885/C%2B%2BJavaPython-Self-Explained-5-line-O(N)
 */
package com.zea7ot.leetcode.lvl2.lc0897;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive {
    public TreeNode increasingBST(TreeNode root) {
        return inorder(root, null);
    }

    private TreeNode inorder(TreeNode node, TreeNode tail) {
        if (node == null)
            return tail;
        TreeNode root = inorder(node.left, node);
        node.left = null;
        node.right = inorder(node.right, tail);
        return root;
    }
}
