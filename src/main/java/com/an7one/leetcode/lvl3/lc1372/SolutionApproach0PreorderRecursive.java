/**
 * @author: Leon
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl3.lc1372;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public int longestZigZag(TreeNode root) {
        int[] longest = { 0 };
        preorder(root.left, true, 1, longest);
        preorder(root.right, false, 1, longest);
        return longest[0];
    }

    private void preorder(TreeNode node, boolean cameFromLeft, int len, int[] longest) {
        if (node == null)
            return;

        longest[0] = Math.max(longest[0], len);

        if (cameFromLeft) {
            preorder(node.left, true, 1, longest);
            preorder(node.right, false, len + 1, longest);
        } else {
            preorder(node.left, true, len + 1, longest);
            preorder(node.right, false, 1, longest);
        }
    }
}
