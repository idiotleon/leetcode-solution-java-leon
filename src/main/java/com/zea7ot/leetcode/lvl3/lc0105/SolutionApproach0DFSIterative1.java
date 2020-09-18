/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34555/The-iterative-solution-is-easier-than-you-think!/557063
 */
package com.zea7ot.leetcode.lvl3.lc0105;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSIterative1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // sanity check
        if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0
                || inorder.length != preorder.length)
            return null;

        final int L = preorder.length;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        TreeNode last = null;
        for (int i = 1, j = 0; i < L; i++) {
            // to backtrack following inorder sequence
            while (j < L && !stack.isEmpty() && stack.peek().val == inorder[j]) {
                last = stack.pop();
                j++;
            }

            TreeNode cur = new TreeNode(preorder[i]);
            if (last == null)
                stack.peek().left = cur; // to keep going left
            else
                last.right = cur; // to backtrack to the "last" and go right

            stack.push(cur);
            last = null;
        }

        return root;
    }
}