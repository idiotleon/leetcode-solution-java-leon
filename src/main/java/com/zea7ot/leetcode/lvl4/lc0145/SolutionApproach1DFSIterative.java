/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  To make sure that all children of a node are traversed
 *  https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization/44991
 */
package com.zea7ot.leetcode.lvl4.lc0145;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach1DFSIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (!isLeaf(cur)) {
                stack.push(cur);
                cur = cur.left;
            }

            if (cur != null)
                ans.add(cur.val);

            while (!stack.isEmpty() && cur == stack.peek().right) {
                cur = stack.pop();
                ans.add(cur.val);
            }

            if (stack.isEmpty())
                cur = null;
            else
                cur = stack.peek().right;
        }

        return ans;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return true;
        return node.left == null && node.right == null;
    }
}