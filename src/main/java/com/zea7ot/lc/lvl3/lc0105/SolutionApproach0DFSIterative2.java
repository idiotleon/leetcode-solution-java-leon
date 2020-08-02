/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34555/The-iterative-solution-is-easier-than-you-think!/117721
 */
package com.zea7ot.lc.lvl3.lc0105;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSIterative2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // sanity check
        if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0
                || inorder.length != preorder.length)
            return null;

        final int L = preorder.length;
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < L; i++) {
            idxMap.put(inorder[i], i);
        }

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        stack.push(root);

        for (int i = 1; i < L; i++) {
            int value = preorder[i];
            TreeNode node = new TreeNode(value);

            if (idxMap.get(value) < idxMap.get(stack.peek().val)) {
                stack.peek().left = node;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && idxMap.get(value) > idxMap.get(stack.peek().val)) {
                    parent = stack.pop();
                }

                parent.right = node;
            }
            stack.push(node);
        }

        return root;
    }
}