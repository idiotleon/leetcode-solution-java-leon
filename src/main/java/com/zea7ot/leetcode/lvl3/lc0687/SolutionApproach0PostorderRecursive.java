/**
 * https://leetcode.com/problems/longest-univalue-path/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0687;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int longestUnivaluePath(TreeNode root) {
        int[] longest = { 0 };
        postorder(root, longest);
        return longest[0];
    }

    private int postorder(TreeNode node, int[] longest) {
        if (node == null)
            return 0;

        int left = postorder(node.left, longest);
        int right = postorder(node.right, longest);

        int pathLeft = 0, pathRight = 0;
        if (node.left != null && node.val == node.left.val)
            pathLeft = left + 1;
        if (node.right != null && node.val == node.right.val)
            pathRight = right + 1;

        longest[0] = Math.max(longest[0], pathLeft + pathRight);

        return Math.max(pathLeft, pathRight);
    }
}