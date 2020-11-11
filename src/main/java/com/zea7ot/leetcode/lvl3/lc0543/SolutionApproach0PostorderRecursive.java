/**
 * @author: Leon
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a bottom up approach
 */
package com.zea7ot.leetcode.lvl3.lc0543;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] longest = { 0 };
        postorder(root, longest);
        return longest[0];
    }

    private int postorder(TreeNode node, int[] longest) {
        if (node == null)
            return 0;

        int left = postorder(node.left, longest);
        int right = postorder(node.right, longest);

        longest[0] = Math.max(longest[0], left + right);

        return Math.max(left, right) + 1;
    }
}