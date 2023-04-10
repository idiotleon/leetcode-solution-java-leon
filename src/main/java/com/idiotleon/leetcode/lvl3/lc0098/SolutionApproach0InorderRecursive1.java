/**
 * @author: Leon
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N)
 */
package com.idiotleon.leetcode.lvl3.lc0098;

import java.util.LinkedList;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive1 {
    public boolean isValidBST(TreeNode root) {
        return inorder(root, new LinkedList<Integer>());
    }

    private boolean inorder(TreeNode node, LinkedList<Integer> sorted) {
        if (node == null)
            return true;

        boolean left = inorder(node.left, sorted);
        if (!sorted.isEmpty() && sorted.peekLast() >= node.val)
            return false;
        sorted.add(node.val);
        boolean right = inorder(node.right, sorted);

        return left && right;
    }
}
