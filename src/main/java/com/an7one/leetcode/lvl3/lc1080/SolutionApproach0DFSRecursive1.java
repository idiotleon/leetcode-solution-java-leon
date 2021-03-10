/**
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/discuss/308326/JavaC%2B%2BPython-Easy-and-Concise-Recursion
 */
package com.an7one.leetcode.lvl3.lc1080;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive1 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        // sanity check
        if (root == null)
            return null;
        if (isLeaf(root))
            return root.val < limit ? null : root;

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        return isLeaf(root) ? null : root;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
            
        return node.left == null && node.right == null;
    }
}