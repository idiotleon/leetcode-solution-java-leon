/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
 */
package com.zea7ot.leetcode.lvl3.lc0098;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0InorderIterative1 {
    public boolean isValidBST(TreeNode root) {
        // sanity check
        if (root == null)
            return true;

        Integer prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            pushLeft(cur, stack);

            cur = stack.pop();
            if (prev != null && prev >= cur.val)
                return false;
            prev = cur.val;
            cur = cur.right;
        }

        return true;
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
